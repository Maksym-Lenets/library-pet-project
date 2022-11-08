package academy.softserve.library.repository;

import academy.softserve.library.model.Book;

import java.util.List;

public interface BookRepository extends GenericRepository<Book, Long> {
    List<Book> getAllAvailable();

    List<Book> getAllAvailablePaginated(Integer page, Integer numbersOfRecords);

    Long countAvailableBooks();
}
