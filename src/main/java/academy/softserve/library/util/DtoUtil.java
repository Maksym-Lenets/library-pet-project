package academy.softserve.library.util;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Author;
import academy.softserve.library.model.Book;
import academy.softserve.library.model.Status;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DtoUtil {
    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setCopiesAmount(book.getInstances().size());

        bookDto.setAvailableCopiesAmount((int) book.getInstances().stream()
                .filter(b -> b.getStatus().equals(Status.AVAILABLE))
                .count());

        bookDto.setAuthor(toAuthorDto(book.getAuthor()));
        bookDto.setCoAuthors(toAuthorDtoList(book.getCoAuthors()));
        return bookDto;
    }

    public static Book toBook(BookDto dto, Book book) {
        book.setTitle(dto.getTitle());
        Author author = new Author();
        author.setId(dto.getAuthor().getId());
        book.setAuthor(author);
        updateBookCopies(dto.getCopiesAmount(), book);
        return book;
    }

    public static <T extends Collection<Book>> List<BookDto> toBooksDtoList(T books) {
        return books.stream()
                .map(DtoUtil::toBookDto)
                .collect(Collectors.toList());
    }

    public static AuthorDto toAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        authorDto.setFullName(author.getFirstName() + " " + author.getLastName());
        return authorDto;
    }

    public static Author toAuthor(AuthorDto dto, Author author) {
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        return author;
    }


    public static <T extends Collection<Author>> List<AuthorDto> toAuthorDtoList(T authors) {
        return authors.stream()
                .map(DtoUtil::toAuthorDto)
                .collect(Collectors.toList());
    }

    public static Set<AuthorDto> toAuthorDtoSet(Set<Author> authors) {
        return authors.stream()
                .map(DtoUtil::toAuthorDto)
                .collect(Collectors.toSet());
    }

    private static void updateBookCopies(Integer updatedAmount, Book book) {

        while (updatedAmount > book.getInstances().size()) {
            book.addNewInstance();
        }


        if (updatedAmount < book.getInstances().size()) {
            for (int i = book.getInstances().size() - updatedAmount; i > 0; i--) {
                book.removeInstance();
            }
        }

    }
}
