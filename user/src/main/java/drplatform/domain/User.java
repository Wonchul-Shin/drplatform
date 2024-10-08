package drplatform.domain;

import drplatform.UserApplication;
import drplatform.domain.PointChanged;
import drplatform.domain.PointWithdrawn;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long point;

    private Long capacity;

    @PostPersist
    public void onPostPersist() {
        PointChanged pointChanged = new PointChanged(this);
        pointChanged.publishAfterCommit();

        PointWithdrawn pointWithdrawn = new PointWithdrawn(this);
        pointWithdrawn.publishAfterCommit();
    }

    public static UserRepository repository() {
        UserRepository userRepository = UserApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public static void changePoint(ReductionCheck reductionCheck) {
        //implement business logic here:

        /** Example 1:  new item 
        User user = new User();
        repository().save(user);

        */

        /** Example 2:  finding and process
        
        repository().findById(reductionCheck.get???()).ifPresent(user->{
            
            user // do something
            repository().save(user);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
