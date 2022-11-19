package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto extends BaseDto {

    private String firstName;

    private String lastName;

    private String fullName;

}
