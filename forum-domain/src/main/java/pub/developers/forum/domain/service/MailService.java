package pub.developers.forum.domain.service;

import pub.developers.forum.domain.entity.Message;


public interface MailService {

    void sendHtml(Message mailMessage);

    void sendText(Message mailMessage);

}
