package academy.softserve.library.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book extends BaseEntity {

    @NotBlank
    private String title;

    @NotNull
    @ManyToOne
    private Author author;

    @ManyToMany
    @ToString.Exclude
    private List<Author> coAuthors;

    @OneToMany
    @ToString.Exclude
    private List<BookInstance> instances;
}
