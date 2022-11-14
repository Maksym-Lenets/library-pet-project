package academy.softserve.library.repository;

import academy.softserve.library.model.Book;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends GenericRepository<Book, Long> {
    List<Book> getAllAvailable();

    List<Book> getAllAvailablePaginated(Integer page, Integer numbersOfRecords);

    List<Book> getBooksByTitle(String title);

    Long countAvailableBooks();

    List<Book> getMostPopularBooks(Integer numberOfRecords, LocalDate startPeriod, LocalDate endPeriod);

    List<Book> getLeastPopularBooks(Integer numberOfRecords, LocalDate fromDate, LocalDate toDate);
}
