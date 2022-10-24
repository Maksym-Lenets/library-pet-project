package academy.softserve.library.dto;

import academy.softserve.library.model.Author;
import academy.softserve.library.model.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String title;

    //TODO replace with DTO
    private Author author;

    public static BookDto toBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.id = book.getId();
        bookDto.title = book.getTitle();
        bookDto.author = book.getAuthor();
        return bookDto;
    }

    public Book toBook(Book book) {
        book.setTitle(this.title);
        book.setAuthor(this.author);
        return book;
    }

}
