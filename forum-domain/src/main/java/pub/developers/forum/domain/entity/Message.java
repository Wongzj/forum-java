package pub.developers.forum.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pub.developers.forum.common.enums.MessageChannelEn;
import pub.developers.forum.common.enums.MessageContentTypeEn;
import pub.developers.forum.common.enums.MessageReadEn;
import pub.developers.forum.common.enums.MessageTypeEn;
import pub.developers.forum.domain.entity.value.IdValue;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message extends BaseEntity {


    private MessageChannelEn channel;


    private MessageTypeEn type;


    private MessageReadEn read;


    private IdValue sender;


    private IdValue receiver;


    private String title;


    private MessageContentTypeEn contentType;


    private String content;

}
