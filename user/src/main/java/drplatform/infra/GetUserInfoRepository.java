package drplatform.infra;

import drplatform.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "getUserInfos",
    path = "getUserInfos"
)
public interface GetUserInfoRepository
    extends PagingAndSortingRepository<GetUserInfo, Long> {}
