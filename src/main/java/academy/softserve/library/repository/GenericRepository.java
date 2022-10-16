package academy.softserve.library.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    List<T> getAll();

    T get(ID id);

    T saveOrUpdate(T element);

    boolean remove(ID id);

}
