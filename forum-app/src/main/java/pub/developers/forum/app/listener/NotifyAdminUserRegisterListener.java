package pub.developers.forum.app.listener;

import org.springframework.stereotype.Component;
import pub.developers.forum.common.enums.MessageChannelEn;
import pub.developers.forum.common.enums.MessageTypeEn;
import pub.developers.forum.common.support.EventBus;
import pub.developers.forum.domain.entity.Message;
import pub.developers.forum.domain.entity.User;
import pub.developers.forum.domain.service.MessageService;

import javax.annotation.Resource;

@Component
public class NotifyAdminUserRegisterListener extends EventBus.EventHandler<User> {

    @Resource
    private MessageService messageService;

    @Override
    public EventBus.Topic topic() {
        return EventBus.Topic.USER_REGISTER;
    }

    @Override
    public void onMessage(User user) {

        messageService.send(Message.builder()
                .channel(MessageChannelEn.MAIL)
                .type(MessageTypeEn.USER_REGISTER_NOTIFY_ADMIN)
                .title("")
                .content("")
                .build());
    }
}
