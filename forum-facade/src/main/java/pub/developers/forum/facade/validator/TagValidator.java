package pub.developers.forum.facade.validator;

import pub.developers.forum.api.request.tag.TagCreateRequest;
import pub.developers.forum.common.support.CheckUtil;


public class TagValidator {

    public static void create(TagCreateRequest request) {
        CheckUtil.checkParamToast(request, "request");
        CheckUtil.checkParamToast(request.getName(), "name");
        CheckUtil.checkParamToast(request.getGroupName(), "groupName");
        CheckUtil.checkParamToast(request.getDescription(), "description");
    }

}
