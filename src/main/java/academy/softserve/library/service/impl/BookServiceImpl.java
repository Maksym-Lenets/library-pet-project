package academy.softserve.library.service.impl;

import academy.softserve.library.repository.BookInstanceRepository;
import academy.softserve.library.repository.BookRepository;
import academy.softserve.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookInstanceRepository bookInstanceRepository) {
        this.bookRepository = bookRepository;
        this.bookInstanceRepository = bookInstanceRepository;
    }

}
