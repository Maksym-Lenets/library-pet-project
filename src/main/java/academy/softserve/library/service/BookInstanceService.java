package academy.softserve.library.service;

import academy.softserve.library.model.Book;
import academy.softserve.library.model.BookInstance;

import java.util.List;
import java.util.Set;

public interface BookInstanceService {
    List<BookInstance> getAll();

    BookInstance get(Long id);

    BookInstance save(BookInstance bookInstance);

    Set<BookInstance> save(Set<BookInstance> bookInstances);

    BookInstance update(BookInstance bookInstance);

    boolean remove(Long id);
}
