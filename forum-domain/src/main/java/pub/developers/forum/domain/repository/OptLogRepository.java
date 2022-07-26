package pub.developers.forum.domain.repository;

import pub.developers.forum.common.model.PageRequest;
import pub.developers.forum.common.model.PageResult;
import pub.developers.forum.domain.entity.OptLog;


public interface OptLogRepository {

    void save(OptLog optLog);

    PageResult<OptLog> page(PageRequest<OptLog> pageRequest);
}
