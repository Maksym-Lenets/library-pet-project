package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.BookInstance;
import academy.softserve.library.repository.BookInstanceRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateBookInstanceRepositoryImpl implements BookInstanceRepository {
    @Override
    public List<BookInstance> getAll() {
        return null;
    }

    @Override
    public BookInstance get(Long id) {
        return null;
    }

    @Override
    public BookInstance saveOrUpdate(BookInstance element) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
