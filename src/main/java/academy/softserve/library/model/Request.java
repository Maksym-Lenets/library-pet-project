package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    private Date requestDate = new Date();

    private Date shouldBeReturn;

    private Date getBookDate;

    private Date returnBookDate;

}
