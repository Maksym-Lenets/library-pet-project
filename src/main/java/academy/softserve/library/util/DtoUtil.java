package academy.softserve.library.util;

import academy.softserve.library.dto.AuthorDto;
import academy.softserve.library.dto.BookDto;
import academy.softserve.library.model.Author;
import academy.softserve.library.model.Book;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DtoUtil {
    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setCopiesAmount(book.getInstances().size());
        bookDto.setAuthorFullName(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
        bookDto.setAuthor(toAuthorDto(book.getAuthor()));
        bookDto.setCoAuthors(toAuthorDtoSet(book.getCoAuthors()));
        return bookDto;
    }

    public static Book toBook(BookDto dto, Book book) {
        book.setTitle(dto.getTitle());
        return book;
    }

    public static List<BookDto> toBooksDtoList(List<Book> books) {
        return books.stream()
                .map(DtoUtil::toBookDto)
                .collect(Collectors.toList());
    }

    public static AuthorDto toAuthorDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setFirstName(author.getFirstName());
        authorDto.setLastName(author.getLastName());
        return authorDto;
    }

    public static Author toAuthor(AuthorDto dto, Author author) {
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        return author;
    }

    public static Set<AuthorDto> toAuthorDtoSet(Set<Author> authors) {
        return authors.stream()
                .map(DtoUtil::toAuthorDto)
                .collect(Collectors.toSet());
    }
}