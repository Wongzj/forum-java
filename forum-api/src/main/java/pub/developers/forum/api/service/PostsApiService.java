package pub.developers.forum.api.service;

import pub.developers.forum.api.model.PageRequestModel;
import pub.developers.forum.api.model.PageResponseModel;
import pub.developers.forum.api.model.ResultModel;
import pub.developers.forum.api.request.AdminBooleanRequest;
import pub.developers.forum.api.vo.PostsVO;

public interface PostsApiService {

    ResultModel delete(Long id);

    ResultModel<PageResponseModel<PostsVO>> pagePostsFood(PageRequestModel pageRequestModel);

    ResultModel auditState(AdminBooleanRequest booleanRequest);
}
