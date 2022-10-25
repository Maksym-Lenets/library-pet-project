package academy.softserve.library.service.impl;

import academy.softserve.library.model.BookInstance;
import academy.softserve.library.repository.BookInstanceRepository;
import academy.softserve.library.service.BookInstanceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookInstanceServiceImpl implements BookInstanceService {
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    public BookInstanceServiceImpl(BookInstanceRepository bookInstanceRepository) {
        this.bookInstanceRepository = bookInstanceRepository;
    }


    @Override
    public List<BookInstance> getAll() {
        return bookInstanceRepository.getAll();
    }

    @Override
    public BookInstance get(Long id) {
        return bookInstanceRepository.get(id);
    }

    @Override
    public BookInstance save(BookInstance bookInstance) {
        return bookInstanceRepository.saveOrUpdate(bookInstance);
    }

    @Override
    public BookInstance update(BookInstance bookInstance) {
        return bookInstanceRepository.saveOrUpdate(bookInstance);
    }

    @Override
    public boolean remove(Long id) {
        return bookInstanceRepository.remove(id);
    }
}
