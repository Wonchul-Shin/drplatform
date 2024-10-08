package drplatform.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "GetUserInfo_table")
@Data
public class GetUserInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
