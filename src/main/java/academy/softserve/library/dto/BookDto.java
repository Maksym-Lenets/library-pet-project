package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {


    private Long id;

    private String title;

    private Integer copiesAmount;

    private AuthorDto author;

    private List<AuthorDto> coAuthors;

}
