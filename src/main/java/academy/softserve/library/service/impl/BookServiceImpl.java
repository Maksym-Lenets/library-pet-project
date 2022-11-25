package academy.softserve.library.service.impl;

import academy.softserve.library.model.Book;
import academy.softserve.library.model.BookInstance;
import academy.softserve.library.model.Request;
import academy.softserve.library.model.Status;
import academy.softserve.library.repository.BookInstanceRepository;
import academy.softserve.library.repository.BookRepository;
import academy.softserve.library.repository.RequestRepository;
import academy.softserve.library.repository.UserRepository;
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
    private RequestRepository requestRepository;
    private BookInstanceRepository bookInstanceRepository;
    private UserRepository userRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, RequestRepository requestRepository, BookInstanceRepository bookInstanceRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.requestRepository = requestRepository;
        this.bookInstanceRepository = bookInstanceRepository;
        this.userRepository = userRepository;
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

    @Override
    @Transactional
    public void reserve(Long userId, Long bookId) {
        Book availableBooks = get(bookId);
        Request request = new Request();
        request.setRequestDate(LocalDate.now());
        request.setGetBookDate(LocalDate.now());
        request.setShouldBeReturn(LocalDate.now().plusMonths(1));
        request.setUser(userRepository.get(userId));
        for (BookInstance item : availableBooks.getInstances()){
            if(item.getStatus() == Status.AVAILABLE){
                item.setStatus(Status.UNAVAILABLE);
                request.setBookInstance(item);
                if(availableBooks.getInstances().size() == 1){
                    item.setStatus(Status.UNAVAILABLE);
                }
                break;
            }
        }
        requestRepository.saveOrUpdate(request);

    }

    @Override
    @Transactional
    public void returnBook(Long userId, Long bookId) {
        Request request = requestRepository.getNotReturnedByUserAndBookId(userId, bookId);
        request.setReturnBookDate(LocalDate.now());
        request.getBookInstance().setStatus(Status.AVAILABLE);
        request.getBookInstance().getBook().setStatus(Status.AVAILABLE);

    }
}
