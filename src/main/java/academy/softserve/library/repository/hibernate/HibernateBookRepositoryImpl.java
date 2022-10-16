package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Book;
import academy.softserve.library.repository.BookRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateBookRepositoryImpl implements BookRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBookRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Book get(Long id) {
        return null;
    }

    @Override
    public Book saveOrUpdate(Book element) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
