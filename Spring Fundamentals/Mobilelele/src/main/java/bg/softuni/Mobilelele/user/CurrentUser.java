package bg.softuni.Mobilelele.user;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private String username;
    private String name;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void clear() {
        this.username = null;
        this.name = null;
        this.isLogged = false;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }
}
