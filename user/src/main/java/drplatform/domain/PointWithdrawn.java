package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PointWithdrawn extends AbstractEvent {

    private Long id;
    private String name;
    private Long point;
    private Long capacity;

    public PointWithdrawn(User aggregate) {
        super(aggregate);
    }

    public PointWithdrawn() {
        super();
    }
}
//>>> DDD / Domain Event
