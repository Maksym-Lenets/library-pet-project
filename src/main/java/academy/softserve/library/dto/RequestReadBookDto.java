package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestReadBookDto{
    String title;
    Long bookId;
    Boolean isRead;
    Long day;
}


