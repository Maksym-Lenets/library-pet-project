package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.User;
import academy.softserve.library.repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HibernateUserRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateUserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" FROM User").list();
    }

    @Override
    public User get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User findUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from User where email = :email";
        return (User) session.createQuery(hql)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User saveOrUpdate(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
    }

    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        return user;
    }

    public User update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        return user;
    }

    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = get(id);
        if (user == null) {
            return false;
        }
        session.remove(user);
        return true;
    }
}

