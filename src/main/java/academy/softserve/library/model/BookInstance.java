package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "copies_of_books")
public class BookInstance extends BaseEntity {
    @NotNull
    @ManyToOne
    private Book book;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "bookInstance", orphanRemoval = true)
    @ToString.Exclude
    private List<Request> requests;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
