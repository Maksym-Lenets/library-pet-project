package academy.softserve.library.dto;

import academy.softserve.library.model.Author;
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
    public static AuthorDto toAuthorDto(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorDto.getId());
        authorDto.setFirstName(authorDto.firstName);
        authorDto.setLastName(authorDto.lastName);
        return authorDto;
    }

    public Author toAuthor(Author author){
        author.setFirstName(this.firstName);
        author.setLastName(this.lastName);
        return author;
    }

}
