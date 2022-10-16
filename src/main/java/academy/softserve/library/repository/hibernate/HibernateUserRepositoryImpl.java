package academy.softserve.library.repository.hibernate;

import academy.softserve.library.repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserRepository> getAll() {
        return null;
    }

    @Override
    public UserRepository get(Long id) {
        return null;
    }

    @Override
    public UserRepository saveOrUpdate(UserRepository element) {
        return null;
    }

    @Override
    public boolean remove(Long id) { return false; }
}
