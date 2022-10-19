package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User extends BaseEntity {

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "birthday")
    private Date birthday;

    @Email
    @NotBlank
    @Column(name = "email")
    @Size(max = 50)
    private String email;

    @NotBlank
    @Column(name = "username")
    @Size(min = 5, max = 50)
    private String userName;

    @NotBlank
    @Column(name = "password")
    @Size(min = 5, max = 50)
    private String password;

    @NotNull
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Column(name = "date_of_registration")
    private LocalDate registrationDate = LocalDate.now();


}
