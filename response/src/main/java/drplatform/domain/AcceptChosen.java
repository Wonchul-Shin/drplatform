package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AcceptChosen extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer drId;
    private Integer userCapacity;
    private String answer;

    public AcceptChosen(Response aggregate) {
        super(aggregate);
    }

    public AcceptChosen() {
        super();
    }
}
//>>> DDD / Domain Event
