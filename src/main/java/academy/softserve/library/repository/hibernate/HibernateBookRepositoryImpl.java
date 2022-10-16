package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.Book;
import academy.softserve.library.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateBookRepositoryImpl implements BookRepository {
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
