package academy.softserve.library.repository.hibernate;

import academy.softserve.library.repository.RequestRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateRequestRepositoryImpl implements RequestRepository {
    @Override
    public List<RequestRepository> getAll() {
        return null;
    }

    @Override
    public RequestRepository get(Long id) {
        return null;
    }

    @Override
    public RequestRepository saveOrUpdate(RequestRepository element) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
