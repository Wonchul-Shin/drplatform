package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DRended extends AbstractEvent {

    private Long id;
    private String name;
    private String type;
    private String status;
    private Date date;

    public DRended(Dr aggregate) {
        super(aggregate);
    }

    public DRended() {
        super();
    }
}
//>>> DDD / Domain Event
