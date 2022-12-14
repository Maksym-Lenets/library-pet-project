package academy.softserve.library.service.impl;

import academy.softserve.library.model.Book;
import academy.softserve.library.repository.BookInstanceRepository;
import academy.softserve.library.repository.BookRepository;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Integer DEFAULT_NUMBER_OF_RECORDS = 10;

    private BookRepository bookRepository;

    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookInstanceRepository bookInstanceRepository) {
        this.bookRepository = bookRepository;
        this.bookInstanceRepository = bookInstanceRepository;
    }


    @Override
    @Transactional
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    @Transactional
    public List<Book> getAllAvailable() {
        return bookRepository.getAllAvailable();
    }

    @Transactional
    @Override
    public List<Book> getAllAvailable(Integer page, Integer numberOfRecords) {
        return bookRepository.getAllAvailablePaginated(page, numberOfRecords);
    }

    @Transactional
    @Override
    public List<Book> getAllAvailable(Integer page) {
        return bookRepository.getAllAvailablePaginated(page, DEFAULT_NUMBER_OF_RECORDS);
    }

    @Transactional
    @Override
    public Long countGivenBooks(LocalDate fromDate, LocalDate toDate) {
        return bookInstanceRepository.countGivenBookCopies(fromDate, toDate);
    }

    @Transactional
    @Override
    public List<Book> getAllAvailableByTitle(String title) {
        return bookRepository.getBooksByTitle(title);
    }

    @Transactional
    @Override
    public List<Book> getWithReturnedBackBooksRequests() {
        return bookRepository.getWithReturnedBackRequests();
    }

    @Transactional
    @Override
    public List<Book> getMostPopularBooks(LocalDate fromDate, LocalDate toDate) {
        return bookRepository.getMostPopularBooks(DEFAULT_NUMBER_OF_RECORDS, fromDate, toDate);
    }

    @Transactional
    @Override
    public List<Book> getLeastPopularBooks(LocalDate fromDate, LocalDate toDate) {
        return bookRepository.getLeastPopularBooks(DEFAULT_NUMBER_OF_RECORDS, fromDate, toDate);
    }

    @Transactional
    @Override
    public Integer getLastPageNumber() {
        return getLastPageNumber(DEFAULT_NUMBER_OF_RECORDS);
    }


    @Transactional
    @Override
    public Integer getLastPageNumber(Integer numberOfRecordsPerPage) {
        return (int) Math.ceil((double) countAvailableBooks() / numberOfRecordsPerPage);
    }


    @Transactional
    @Override
    public Long countAvailableBooks() {
        return bookRepository.countAvailableBooks();
    }

    @Transactional
    @Override
    public Book get(Long id) {
        return bookRepository.get(id);
    }

    @Override
    @Transactional
    public Book save(Book book) {
        return bookRepository.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return bookRepository.saveOrUpdate(book);
    }

    @Override
    @Transactional
    public boolean remove(Long id) {
        return bookRepository.remove(id);
    }
}
