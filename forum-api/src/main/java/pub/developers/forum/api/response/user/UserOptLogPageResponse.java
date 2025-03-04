package pub.developers.forum.api.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOptLogPageResponse implements Serializable {

    private Long userId;

    private String avatar;

    private String email;

    private String nickname;

    private String type;

    private String content;

    private String createAt;


}
