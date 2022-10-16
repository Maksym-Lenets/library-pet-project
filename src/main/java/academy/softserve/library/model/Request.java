package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Request extends BaseEntity {

    @OneToOne
    private User user;

    @OneToOne
    private BookInstance bookInstance;

    @NotNull
    private LocalDate requestDate = LocalDate.now();

    private LocalDate shouldBeReturn;

    private LocalDate getBookDate;

    private LocalDate returnBookDate;

}
