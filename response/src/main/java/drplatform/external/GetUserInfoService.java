package drplatform.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user", url = "${api.url.user}")
public interface GetUserInfoService {
    @GetMapping(path = "/getUserInfos")
    public List<GetUserInfo> getGetUserInfo();

    @GetMapping(path = "/getUserInfos/{id}")
    public GetUserInfo getGetUserInfo(@PathVariable("id") Long id);
}
