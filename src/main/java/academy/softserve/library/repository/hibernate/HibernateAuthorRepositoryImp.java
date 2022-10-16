package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Author;
import academy.softserve.library.repository.AuthorRepository;
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
        return null;
    }

    @Override
    public Author get(Long id) {
        return null;
    }

    @Override
    public Author saveOrUpdate(Author element) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
