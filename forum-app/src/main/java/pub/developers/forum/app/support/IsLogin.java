package pub.developers.forum.app.support;

import pub.developers.forum.common.enums.UserRoleEn;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IsLogin {

    UserRoleEn role() default UserRoleEn.USER;

}