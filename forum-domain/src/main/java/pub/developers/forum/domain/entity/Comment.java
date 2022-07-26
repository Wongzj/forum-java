package pub.developers.forum.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {


    private Long userId;

    private Long replyId;


    private Long replyReplyId;

    private Long postsId;


    private String content;

}
