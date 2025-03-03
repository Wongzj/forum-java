package pub.developers.forum.api.service;

import pub.developers.forum.api.model.PageRequestModel;
import pub.developers.forum.api.model.PageResponseModel;
import pub.developers.forum.api.model.ResultModel;
import pub.developers.forum.api.vo.PostsVO;

public interface SearchApiService {

    ResultModel<PageResponseModel<PostsVO>> pagePostsSearch(PageRequestModel<String> pageRequestModel);

}
