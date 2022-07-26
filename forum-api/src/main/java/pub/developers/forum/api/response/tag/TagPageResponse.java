package pub.developers.forum.api.response.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagPageResponse implements Serializable {

    private Long id;

    private String createAt;

    private String updateAt;

    private String groupName;

    private String name;

    private String description;

    private Long refCount;

    private Long creatorId;

    private String auditState;


}
