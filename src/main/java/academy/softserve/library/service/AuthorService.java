package academy.softserve.library.service;

import academy.softserve.library.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    List<Author> getByName(String names);

    Author get(Long id);

    List<Author> get(List<Long> ids);

    Author saveOrUpdate(Author author);

    boolean delete(Long id);

}
