package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Request;
import academy.softserve.library.repository.RequestRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class HibernateRequestRepositoryImpl implements RequestRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateRequestRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Request> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Request", Request.class).list();
    }

    @Override
    public Request get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Request.class, id);
    }

    @Override
    public List<Request> get(LocalDate from, LocalDate to) {
        Session session = sessionFactory.getCurrentSession();
        String hpl = "FROM Request WHERE getBookDate BETWEEN :from AND :to";
        List<Request> list = session.createQuery(hpl)
                .setParameter("from", from)
                .setParameter("to", to)
                .list();
        return list;
    }

    @Override
    public Request saveOrUpdate(Request element) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(element);
        return element;
    }

    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Request request = get(id);
        if (request == null)return false;
        session.remove(request);
        return true;
    }


}
