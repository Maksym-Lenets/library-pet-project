package academy.softserve.library.repository;

import academy.softserve.library.model.BookInstance;

import java.time.LocalDate;

public interface BookInstanceRepository extends GenericRepository<BookInstance, Long> {
    Long countGivenBookCopies(LocalDate fromDate, LocalDate toDate);
}
