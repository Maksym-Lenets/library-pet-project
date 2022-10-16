package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookInstance extends BaseEntity {
    @NotNull
    @OneToOne
    private Book book;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
