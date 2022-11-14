package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BookDto extends BaseDto{

    private String title;

    private Integer copiesAmount;

    private Integer availableCopiesAmount;

    private AuthorDto author;

    private List<AuthorDto> coAuthors = new ArrayList<>();

}
