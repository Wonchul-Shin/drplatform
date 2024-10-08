package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ListSaved extends AbstractEvent {

    private Long id;
    private Integer userId;
    private Integer drId;
    private Integer userCapacity;
    private String answer;
}
