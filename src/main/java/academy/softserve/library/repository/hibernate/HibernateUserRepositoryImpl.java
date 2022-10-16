package academy.softserve.library.repository.hibernate;

import academy.softserve.library.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUserRepositoryImpl implements UserRepository {
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
