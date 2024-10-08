package drplatform.domain;

import drplatform.DrApplication;
import drplatform.domain.DRended;
import drplatform.domain.DRstarted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dr_table")
@Data
//<<< DDD / Aggregate Root
public class Dr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private String status;

    private Date date;

    @PostPersist
    public void onPostPersist() {
        DRstarted dRstarted = new DRstarted(this);
        dRstarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DRended dRended = new DRended(this);
        dRended.publishAfterCommit();
    }

    public static DrRepository repository() {
        DrRepository drRepository = DrApplication.applicationContext.getBean(
            DrRepository.class
        );
        return drRepository;
    }
}
//>>> DDD / Aggregate Root
