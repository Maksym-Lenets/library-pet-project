package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Author;
import academy.softserve.library.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateAuthorRepositoryImp implements AuthorRepository {
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
