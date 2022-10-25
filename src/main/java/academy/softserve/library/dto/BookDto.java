package academy.softserve.library.dto;

import academy.softserve.library.model.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String title;

    private String authorFullName;

    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.id = book.getId();
        bookDto.title = book.getTitle();
        bookDto.setAuthorFullName(book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName() );
        return bookDto;
    }

    public Book toBook(Book book) {
        book.setTitle(this.title);
        return book;
    }

}
