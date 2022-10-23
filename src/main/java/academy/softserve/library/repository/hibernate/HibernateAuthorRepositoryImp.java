package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Author;
import academy.softserve.library.repository.AuthorRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateAuthorRepositoryImp implements AuthorRepository {
    private SessionFactory sessionFactory;
    @Autowired
    public HibernateAuthorRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Author> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Author> list = session.createQuery("from Author").list();
        return list;
    }

    @Override
    public Author get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.load(Author.class, id);
        return author;
    }

    @Override
    public Author saveOrUpdate(Author element) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(element);
        return element;
    }

    @Override
    public boolean remove(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = get(id);
        if (author == null)return false;
        session.remove(author);
        return true;
    }
}
