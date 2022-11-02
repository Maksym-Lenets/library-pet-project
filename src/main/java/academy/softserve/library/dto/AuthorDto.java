package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String fullName;

}
