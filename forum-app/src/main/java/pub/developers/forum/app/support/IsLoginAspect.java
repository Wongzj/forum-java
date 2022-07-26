package pub.developers.forum.app.support;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pub.developers.forum.common.enums.ErrorCodeEn;
import pub.developers.forum.common.enums.UserRoleEn;
import pub.developers.forum.common.exception.BizException;
import pub.developers.forum.common.support.CheckUtil;
import pub.developers.forum.domain.entity.User;

@Component
@Aspect
public class IsLoginAspect {


    @Around("execution(* pub.developers.forum..*.*(..)) && @annotation(isLogin)")
    public Object process(ProceedingJoinPoint joinPoint, IsLogin isLogin) throws Throwable {
        User loginUser = LoginUserContext.getUser();
        CheckUtil.isEmpty(loginUser, ErrorCodeEn.USER_NOT_LOGIN);

        UserRoleEn userRoleEn = loginUser.getRole();

        if (UserRoleEn.SUPER_ADMIN.equals(isLogin.role())) {
            if (UserRoleEn.SUPER_ADMIN.equals(userRoleEn)) {
                return joinPoint.proceed();
            }
            throw new BizException(ErrorCodeEn.COMMON_TOKEN_NO_PERMISSION);
        }

        else if (UserRoleEn.ADMIN.equals(isLogin.role())) {
            if (UserRoleEn.SUPER_ADMIN.equals(userRoleEn)
                    || UserRoleEn.ADMIN.equals(userRoleEn)) {
                return joinPoint.proceed();
            }
            throw new BizException(ErrorCodeEn.COMMON_TOKEN_NO_PERMISSION);
        }

        return joinPoint.proceed();
    }

}
