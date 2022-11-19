package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Book;
import academy.softserve.library.model.BookInstance;
import academy.softserve.library.model.Status;
import academy.softserve.library.repository.BookRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class HibernateBookRepositoryImpl implements BookRepository {

    private SessionFactory sessionFactory;


    @Autowired
    public HibernateBookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Book").getResultList();
    }

    @Override
    public List<Book> getAllAvailable() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE b.status =:s", Book.class);
        query.setParameter("s", Status.AVAILABLE);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllAvailablePaginated(Integer page, Integer numbersOfRecords) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE b.status =:s", Book.class);
        query.setParameter("s", Status.AVAILABLE);
        query.setFirstResult((page - 1) * numbersOfRecords);
        query.setMaxResults(numbersOfRecords);
        return query.list();
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE b.status =:s AND LOWER (b.title) like :t", Book.class);
        query.setParameter("s", Status.AVAILABLE);
        query.setParameter("t", "%" + title.toLowerCase() + "%");
        return query.list();
    }

    @Override
    public Long countAvailableBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery("SELECT COUNT (b.id) FROM Book b WHERE b.status =:s", Long.class);
        query.setParameter("s", Status.AVAILABLE);
        return query.uniqueResult();
    }

    @Override
    public Book get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE b.id =:id", Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Book> getWithReturnedBackRequests() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT r.bookInstance.book FROM Request r" +
                " WHERE r.returnBookDate IS NOT NULL", Book.class);
        List<Book> books = query.getResultList();
        for (Book book : books) {
            book.getInstances().forEach(i -> Hibernate.initialize(i.getRequests()));
        }
        return books;
    }

    @Override
    public List<Book> getMostPopularBooks(Integer numberOfRecords, LocalDate fromDate, LocalDate toDate) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT r.bookInstance.book FROM Request r " +
                "WHERE r.requestDate BETWEEN :from AND :to " +
                "GROUP BY r.bookInstance.book " +
                "ORDER BY COUNT (r.bookInstance.book) DESC, r.bookInstance.book.title ASC", Book.class);
        query.setParameter("from", fromDate)
                .setParameter("to", toDate)
                .setFirstResult(0)
                .setMaxResults(numberOfRecords);

        return query.list();
    }

    @Override
    public List<Book> getLeastPopularBooks(Integer numberOfRecords, LocalDate fromDate, LocalDate toDate) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT r.bookInstance.book FROM Request r " +
                "WHERE r.requestDate BETWEEN :from AND :to " +
                "GROUP BY r.bookInstance.book " +
                "ORDER BY COUNT (r.bookInstance.book) ASC, r.bookInstance.book.title ASC", Book.class);
        query.setParameter("from", fromDate)
                .setParameter("to", toDate)
                .setFirstResult(0)
                .setMaxResults(numberOfRecords);

        return query.list();
    }

    @Override
    public Book saveOrUpdate(Book element) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(element);
        return element;
    }


    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        if (book != null) {
            for (BookInstance copy : book.getInstances()) {
                if (copy.getStatus().equals(Status.UNAVAILABLE)) {
                    return false;
                }
                copy.setStatus(Status.DELETED);
            }
            book.setStatus(Status.DELETED);
            session.update(book);
            return true;
        }
        return false;
    }
}
