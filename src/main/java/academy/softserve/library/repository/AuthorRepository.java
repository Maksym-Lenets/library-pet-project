package academy.softserve.library.repository;

import academy.softserve.library.model.Author;

import java.util.List;

public interface AuthorRepository extends GenericRepository<Author, Long> {
    List<Author> getList(List<Long> ids);

}
