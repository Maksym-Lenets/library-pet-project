package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.User;
import academy.softserve.library.repository.UserRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;


@Repository
public class HibernateUserRepositoryImpl implements UserRepository {
    private static final Logger logger = LoggerFactory.getLogger(HibernateUserRepositoryImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public HibernateUserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User existUser = session.load(User.class, user.getEmail());
        session.persist(user);
        logger.info("User is successfully added.");
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, email);
        return Optional.of(user);
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery(" FROM User").list();
        logger.info("Successfully get all users");
        return userList;
    }

    @Override
    public User get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        logger.info("Successfully loaded user. User details: " + user);
        return user;
    }

    @Override
    public User saveOrUpdate(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User details: " + user);
        return user;
    }

    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
            logger.info("User successfully deleted");
            return true;
        } else {
            logger.info("User with id " + id + " not exists!");
            return false;
        }
    }
}
