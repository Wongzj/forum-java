package pub.developers.forum.app.listener;

import org.springframework.stereotype.Component;
import pub.developers.forum.common.enums.PostsCategoryEn;
import pub.developers.forum.common.support.EventBus;
import pub.developers.forum.domain.entity.BasePosts;
import pub.developers.forum.domain.repository.ArticleTypeRepository;

import javax.annotation.Resource;

@Component
public class PostsDeleteListener extends EventBus.EventHandler<BasePosts> {

    @Resource
    private ArticleTypeRepository articleTypeRepository;

    @Override
    public EventBus.Topic topic() {
        return EventBus.Topic.POSTS_DELETE;
    }

    @Override
    public void onMessage(BasePosts basePosts) {
        if (PostsCategoryEn.ARTICLE.equals(basePosts.getCategory())) {
            articleTypeRepository.decreaseRefCount(basePosts.getTypeId());
        }
    }
}
