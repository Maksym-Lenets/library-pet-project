package academy.softserve.library.service.impl;

import academy.softserve.library.model.Book;
import academy.softserve.library.repository.BookRepository;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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

    @Override
    @Transactional
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
