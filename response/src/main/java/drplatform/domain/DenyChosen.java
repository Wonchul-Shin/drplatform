package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DenyChosen extends AbstractEvent {

    private Long id;

    public DenyChosen(Response aggregate) {
        super(aggregate);
    }

    public DenyChosen() {
        super();
    }
}
//>>> DDD / Domain Event
