package academy.softserve.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookInstanceDto extends BaseDto {

    private Long avgDaysOfReading;

    private Integer numberOfFinishedRequests;

}
