package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Book;
import academy.softserve.library.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        return session.createQuery("From Book").getResultList();
    }

    @Override
    public Book get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Book.class, id);
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
            session.delete(book);
            return true;
        }
        return false;
    }
}
