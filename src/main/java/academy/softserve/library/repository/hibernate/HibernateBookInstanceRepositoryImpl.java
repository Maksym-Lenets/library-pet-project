package academy.softserve.library.repository.hibernate;

import academy.softserve.library.model.BookInstance;
import academy.softserve.library.repository.BookInstanceRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateBookInstanceRepositoryImpl implements BookInstanceRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public HibernateBookInstanceRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
