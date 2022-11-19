package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.BookInstance;
import academy.softserve.library.model.Status;
import academy.softserve.library.repository.BookInstanceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    public Long countGivenBookCopies(LocalDate fromDate, LocalDate toDate) {
        Session session = sessionFactory.getCurrentSession();
        Query<Long> query = session.createQuery("SELECT COUNT (r.id) FROM Request r WHERE r.getBookDate BETWEEN :from AND :to", Long.class);
        query.setParameter("from", fromDate)
                .setParameter("to", toDate);
        return query.getSingleResult();
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
            bookInstance.setStatus(Status.DELETED);
            session.update(bookInstance);
            return true;
        }
        return false;
    }
}
