package academy.softserve.library.service.impl;

import academy.softserve.library.repository.BookInstanceRepository;
import academy.softserve.library.service.BookInstanceService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookInstanceServiceImpl implements BookInstanceService {
    private BookInstanceRepository bookInstanceRepository;

    @Autowired
    public BookInstanceServiceImpl(BookInstanceRepository bookInstanceRepository) {
        this.bookInstanceRepository = bookInstanceRepository;
    }


}
