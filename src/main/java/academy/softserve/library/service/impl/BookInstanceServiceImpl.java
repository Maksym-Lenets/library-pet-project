package academy.softserve.library.service.impl;

import academy.softserve.library.model.BookInstance;
import academy.softserve.library.repository.BookInstanceRepository;
import academy.softserve.library.service.BookInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BookInstanceServiceImpl implements BookInstanceService {
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    public BookInstanceServiceImpl(BookInstanceRepository bookInstanceRepository) {
        this.bookInstanceRepository = bookInstanceRepository;
    }

    @Transactional
    @Override
    public List<BookInstance> getAll() {
        return bookInstanceRepository.getAll();
    }

    @Override
    public BookInstance get(Long id) {
        return bookInstanceRepository.get(id);
    }

    @Transactional
    @Override
    public BookInstance save(BookInstance bookInstance) {
        return bookInstanceRepository.saveOrUpdate(bookInstance);
    }

    @Transactional
    @Override
    public Set<BookInstance> save(Set<BookInstance> bookInstances) {
        for(BookInstance b : bookInstances){
            bookInstanceRepository.saveOrUpdate(b);
        }
        return bookInstances;
    }

    @Transactional
    @Override
    public BookInstance update(BookInstance bookInstance) {
        return bookInstanceRepository.saveOrUpdate(bookInstance);
    }

    @Transactional
    @Override
    public boolean remove(Long id) {
        return bookInstanceRepository.remove(id);
    }
}
