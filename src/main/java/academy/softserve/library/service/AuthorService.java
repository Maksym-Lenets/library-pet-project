package academy.softserve.library.service;

import academy.softserve.library.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author get(Long id);
    Author saveOrUpdate(Author author);
    boolean delete(Long id);

}
