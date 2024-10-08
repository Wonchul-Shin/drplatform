package drplatform.domain;

import drplatform.domain.*;
import drplatform.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ReductionCheck extends AbstractEvent {

    private Long id;
    private Long drId;
    private Long userId;
    private Long responseId;
    private String responseAnswer;
    private Long adjustPoint;
    private Boolean isReal;
}
