package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Book;
import academy.softserve.library.model.Status;
import academy.softserve.library.repository.BookRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        Query<Book> query = session.createQuery("FROM Book WHERE status =:s");
        query.setParameter("s", Status.AVAILABLE);
        return query.getResultList();
    }

    @Override
    public Book get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        Hibernate.initialize(book.getAuthor());
        Hibernate.initialize(book.getInstances());
        return book;
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
