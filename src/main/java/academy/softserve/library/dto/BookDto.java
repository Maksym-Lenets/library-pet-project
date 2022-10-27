package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {

    private Long id;

    private String title;

    private String authorFullName;

    private Integer copiesAmount;

    private AuthorDto author;

    private Set<AuthorDto> coAuthors;

}
