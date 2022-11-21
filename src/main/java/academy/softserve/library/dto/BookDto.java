package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto extends BaseDto {

    private String title;

    private Integer copiesAmount;

    private Integer availableCopiesAmount;

    private AuthorDto author;

    private Integer avgReadingTime;

    private List<AuthorDto> coAuthors = new ArrayList<>();

    private List<BookInstanceDto> copies = new ArrayList<>();

}
