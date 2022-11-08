package academy.softserve.library.service;

import academy.softserve.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    List<Book> getAllAvailable();

    public List<Book> getAllAvailable(Integer page);

    public List<Book> getAllAvailable(Integer page, Integer numberOfRecords);

    Long countAvailableBooks();

    Integer getLastPageNumber(Integer numberOfRecordsPerPage);
    Integer getLastPageNumber();

    Book get(Long id);

    Book save(Book book);

    Book update(Book book);

    boolean remove(Long id);
}
