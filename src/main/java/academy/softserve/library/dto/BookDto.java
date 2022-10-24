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

    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.id = book.getId();
        bookDto.title = book.getTitle();
        return bookDto;
    }

    public Book toBook(Book book) {
        book.setTitle(this.title);
        return book;
    }

}
