package academy.softserve.library.dto;

import academy.softserve.library.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserNotReturnedBookInTimeDto {
    String first_name;
    String last_name;
    String email;
    LocalDate birthday;
    LocalDate registrationDate;
    Role role;
    Long countOfNotReturnedInBooksInTime;
}
