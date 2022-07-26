package pub.developers.forum.api.request.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleAdminTypePageRequest implements Serializable {

    private String name;

    private String description;

    private String scope;

    private String auditState;
}
