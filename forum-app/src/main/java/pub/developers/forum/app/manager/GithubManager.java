package pub.developers.forum.app.manager;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import pub.developers.forum.api.request.github.GithubOauthLoginRequest;
import pub.developers.forum.app.transfer.UserTransfer;
import pub.developers.forum.common.enums.ErrorCodeEn;
import pub.developers.forum.common.enums.UserSourceEn;
import pub.developers.forum.common.enums.UserStateEn;
import pub.developers.forum.common.support.CheckUtil;
import pub.developers.forum.common.support.EventBus;
import pub.developers.forum.domain.entity.User;
import pub.developers.forum.domain.service.GithubService;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class GithubManager extends AbstractLoginManager {

    @Resource
    private GithubService githubService;

    public String oauthLogin(GithubOauthLoginRequest request) {
        JSONObject githubUser = githubService.getUserInfo(request.getCode());

        String loginName = githubUser.getString("login");
        String email = ObjectUtils.isEmpty(githubUser.getString("email")) ? loginName + "@github.com" : githubUser.getString("email");
        String nickname = ObjectUtils.isEmpty(githubUser.getString("name")) ? loginName : githubUser.getString("name");
        String signature = ObjectUtils.isEmpty(githubUser.getString("bio")) ? "" : githubUser.getString("bio");
        String avatar = ObjectUtils.isEmpty(githubUser.getString("avatar_url")) ? "" : githubUser.getString("avatar_url");

        User user = userRepository.getByEmail(email);

        if (ObjectUtils.isEmpty(user)) {
            user = UserTransfer.toGithubUser(githubUser, email, nickname, signature, avatar);
            userRepository.save(user);

            EventBus.emit(EventBus.Topic.USER_REGISTER, user);
        } else {
            CheckUtil.isTrue(UserStateEn.DISABLE.equals(user.getState()), ErrorCodeEn.USER_STATE_IS_DISABLE);
            user.setLastLoginTime(new Date());
            user.setSource(UserSourceEn.GITHUB);
            user.setGithubUser(githubUser);
            user.setNickname(nickname);
            if (!ObjectUtils.isEmpty(signature)) {
                user.setSignature(signature);
            }
            if (!ObjectUtils.isEmpty(avatar)) {
                user.setAvatar(avatar);
            }

            userRepository.update(user);
        }

        return login(user, request);
    }
}
