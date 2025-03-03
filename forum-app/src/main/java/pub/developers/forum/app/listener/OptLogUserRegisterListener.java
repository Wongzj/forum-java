package pub.developers.forum.app.listener;

import org.springframework.stereotype.Component;
import pub.developers.forum.common.support.EventBus;
import pub.developers.forum.domain.entity.OptLog;
import pub.developers.forum.domain.entity.User;
import pub.developers.forum.domain.repository.OptLogRepository;

import javax.annotation.Resource;

@Component
public class OptLogUserRegisterListener extends EventBus.EventHandler<User> {

    @Resource
    private OptLogRepository optLogRepository;

    @Override
    public EventBus.Topic topic() {
        return EventBus.Topic.USER_REGISTER;
    }

    @Override
    public void onMessage(User user) {

        optLogRepository.save(OptLog.createUserRegisterRecordLog(user.getId(), user));
    }
}
