package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DRended extends AbstractEvent {

    private Long id;
    private String name;
    private String type;
    private String status;
    private Date date;
}
