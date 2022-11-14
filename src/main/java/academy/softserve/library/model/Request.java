package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "history_of_request")
public class Request extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "book_instance_id")
    private BookInstance bookInstance;

    @NotNull
    @Column(name = "date_of_request")
    private LocalDate requestDate = LocalDate.now();

    @Column(name = "should_be_return")
    private LocalDate shouldBeReturn;

    @Column(name = "get_book_date")
    private LocalDate getBookDate;

    @Column(name = "return_date")
    private LocalDate returnBookDate;

}
