package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Request;
import academy.softserve.library.repository.RequestRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateRequestRepositoryImpl implements RequestRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateRequestRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Request> getAll() {
        return null;
    }

    @Override
    public Request get(Long id) {
        return null;
    }

    @Override
    public Request saveOrUpdate(Request element) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
