package drplatform.domain;

import drplatform.ResponseApplication;
import drplatform.domain.AcceptChosen;
import drplatform.domain.DenyChosen;
import drplatform.domain.ListMade;
import drplatform.domain.ListSaved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Response_table")
@Data
//<<< DDD / Aggregate Root
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer userId;

    private Integer drId;

    private Integer userCapacity;

    private String answer;

    @PostPersist
    public void onPostPersist() {
        ListMade listMade = new ListMade(this);
        listMade.publishAfterCommit();

        ListSaved listSaved = new ListSaved(this);
        listSaved.publishAfterCommit();

        AcceptChosen acceptChosen = new AcceptChosen(this);
        acceptChosen.publishAfterCommit();

        DenyChosen denyChosen = new DenyChosen(this);
        denyChosen.publishAfterCommit();
    }

    public static ResponseRepository repository() {
        ResponseRepository responseRepository = ResponseApplication.applicationContext.getBean(
            ResponseRepository.class
        );
        return responseRepository;
    }

    //<<< Clean Arch / Port Method
    public static void makeList(DRstarted dRstarted) {
        //implement business logic here:

        /** Example 1:  new item 
        Response response = new Response();
        repository().save(response);

        */

        /** Example 2:  finding and process
        
        repository().findById(dRstarted.get???()).ifPresent(response->{
            
            response // do something
            repository().save(response);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void saveList(DRended dRended) {
        //implement business logic here:

        /** Example 1:  new item 
        Response response = new Response();
        repository().save(response);

        */

        /** Example 2:  finding and process
        
        repository().findById(dRended.get???()).ifPresent(response->{
            
            response // do something
            repository().save(response);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateResponse(ReductionCheck reductionCheck) {
        //implement business logic here:

        /** Example 1:  new item 
        Response response = new Response();
        repository().save(response);

        */

        /** Example 2:  finding and process
        
        repository().findById(reductionCheck.get???()).ifPresent(response->{
            
            response // do something
            repository().save(response);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
