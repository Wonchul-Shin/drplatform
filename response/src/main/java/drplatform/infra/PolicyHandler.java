package drplatform.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import drplatform.config.kafka.KafkaProcessor;
import drplatform.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ResponseRepository responseRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DRstarted'"
    )
    public void wheneverDRstarted_MakeList(@Payload DRstarted dRstarted) {
        DRstarted event = dRstarted;
        System.out.println(
            "\n\n##### listener MakeList : " + dRstarted + "\n\n"
        );

        // REST Request Sample

        // getUserInfoService.getGetUserInfo(/** mapping value needed */);

        // Sample Logic //
        Response.makeList(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DRended'"
    )
    public void wheneverDRended_SaveList(@Payload DRended dRended) {
        DRended event = dRended;
        System.out.println("\n\n##### listener SaveList : " + dRended + "\n\n");

        // Sample Logic //
        Response.saveList(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReductionCheck'"
    )
    public void wheneverReductionCheck_UpdateResponse(
        @Payload ReductionCheck reductionCheck
    ) {
        ReductionCheck event = reductionCheck;
        System.out.println(
            "\n\n##### listener UpdateResponse : " + reductionCheck + "\n\n"
        );

        // Sample Logic //
        Response.updateResponse(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
