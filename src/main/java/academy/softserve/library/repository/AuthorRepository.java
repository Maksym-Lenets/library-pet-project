package academy.softserve.library.repository;

import academy.softserve.library.model.Author;

import java.util.List;

public interface AuthorRepository extends GenericRepository<Author, Long> {
    List<Author> getAuthorsByName(String... names);

    List<Author> getByIds(List<Long> ids);

}
