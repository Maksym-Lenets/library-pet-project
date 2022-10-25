package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.BookInstance;
import academy.softserve.library.repository.BookInstanceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateBookInstanceRepositoryImpl implements BookInstanceRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBookInstanceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<BookInstance> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From BookInstance").getResultList();
    }

    @Override
    public BookInstance get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(BookInstance.class, id);
    }

    @Override
    public BookInstance saveOrUpdate(BookInstance element) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(element);
        return element;
    }

    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        BookInstance bookInstance = session.get(BookInstance.class, id);
        if (bookInstance != null) {
            session.delete(bookInstance);
            return true;
        }
        return false;
    }
}
