package pub.developers.forum.portal.request;

import lombok.Data;


@Data
public class SearchRequest extends BasePageRequest {

    private String key;
}
