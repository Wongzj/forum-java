package pub.developers.forum.api.service;

import pub.developers.forum.api.model.ResultModel;
import pub.developers.forum.api.request.github.GithubOauthLoginRequest;

public interface GithubApiService {

    ResultModel<String> oauthLogin(GithubOauthLoginRequest request);

}
