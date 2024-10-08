package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ListSaved extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer drId;
    private Integer userCapacity;
    private String answer;

    public ListSaved(Response aggregate) {
        super(aggregate);
    }

    public ListSaved() {
        super();
    }
}
//>>> DDD / Domain Event
