package academy.softserve.library.service;

import academy.softserve.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book get(Long id);

    Book save(Book book);

    Book update(Book book);

    boolean remove(Long id);
}
