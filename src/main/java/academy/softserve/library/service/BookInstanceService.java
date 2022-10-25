package academy.softserve.library.service;

import academy.softserve.library.model.BookInstance;

import java.util.List;

public interface BookInstanceService {
    List<BookInstance> getAll();

    BookInstance get(Long id);

    BookInstance save(BookInstance bookInstance);

    BookInstance update(BookInstance bookInstance);

    boolean remove(Long id);
}
