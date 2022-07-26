package pub.developers.forum.api.response.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentPageResponse implements Serializable {

    private Long id;

    private Date createAt;

    private String content;

    private Long replyId;

    private Commentator commentator;

    private Commentator respondent;

    private List<CommentPageResponse> replies;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Commentator {
        private Long id;
        private String nickname;
        private String avatar;
    }

}
