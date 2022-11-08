package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Book;
import academy.softserve.library.model.Status;
import academy.softserve.library.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE status =:s");
        query.setParameter("s", Status.AVAILABLE);
        return query.getResultList();
    }

    @Override
    public List<Book> getAllAvailablePaginated(Integer page, Integer numbersOfRecords) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE status =:s");
        query.setParameter("s", Status.AVAILABLE);
        query.setFirstResult((page - 1) * numbersOfRecords);
        query.setMaxResults(numbersOfRecords);
        return query.list();
    }

    @Override
    public Long countAvailableBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery("SELECT COUNT (b.id) FROM Book b");
        return query.uniqueResult();
    }

    @Override
    public Book get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT DISTINCT b FROM Book b WHERE id =:id");
        query.setParameter("id", id);
       /* Book book = session.load(Book.class, id);
        Hibernate.initialize(book.getAuthor());
        Hibernate.initialize(book.getCoAuthors());
        Hibernate.initialize(book.getInstances());*/
        return query.getSingleResult();
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
            book.setStatus(Status.UNAVAILABLE);
            session.update(book);
            return true;
        }
        return false;
    }
}
