package pub.developers.forum.api.service;

import pub.developers.forum.api.model.PageRequestModel;
import pub.developers.forum.api.model.PageResponseModel;
import pub.developers.forum.api.model.ResultModel;
import pub.developers.forum.api.request.AdminBooleanRequest;
import pub.developers.forum.api.request.config.ConfigAddRequest;
import pub.developers.forum.api.request.config.ConfigPageRequest;
import pub.developers.forum.api.request.config.ConfigUpdateRequest;
import pub.developers.forum.api.response.config.ConfigResponse;

import java.util.List;
import java.util.Set;

public interface ConfigApiService {

    ResultModel add(ConfigAddRequest request);

    ResultModel update(ConfigUpdateRequest request);

    ResultModel state(AdminBooleanRequest request);

    ResultModel<PageResponseModel<ConfigResponse>> page(PageRequestModel<ConfigPageRequest> pageRequestModel);

    ResultModel<List<ConfigResponse>> queryAvailable(Set<String> types);
}
