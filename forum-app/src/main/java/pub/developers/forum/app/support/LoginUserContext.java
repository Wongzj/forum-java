package pub.developers.forum.app.support;

import pub.developers.forum.domain.entity.User;

public class LoginUserContext {

    private static final ThreadLocal<User> CURRENT_LOGIN_USER = new ThreadLocal<>();

    private static final ThreadLocal<String> CURRENT_USER_LOGIN_TOKEN = new ThreadLocal<>();

    public static void setUser(User loginUser) {
        CURRENT_LOGIN_USER.set(loginUser);
    }

    public static User getUser() {
        return CURRENT_LOGIN_USER.get();
    }

    public static void setToken(String token) {
        CURRENT_USER_LOGIN_TOKEN.set(token);
    }

    public static String getToken() {
        return CURRENT_USER_LOGIN_TOKEN.get();
    }

    public static void removeAll() {
        CURRENT_LOGIN_USER.remove();
        CURRENT_USER_LOGIN_TOKEN.remove();
    }

    private LoginUserContext() {}
}