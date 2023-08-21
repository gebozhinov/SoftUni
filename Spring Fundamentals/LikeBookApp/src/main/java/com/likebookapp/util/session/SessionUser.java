package com.likebookapp.util.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionUser {

    private Long id;
    private String username;
    private String email;
    private boolean isLogged;

    public Long getId() {
        return id;
    }

    public SessionUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SessionUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SessionUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public SessionUser setLogged(boolean logged) {
        isLogged = logged;
        return this;
    }

    public void clear() {
        this.id = null;
        this.username = null;
        this.email = null;
        this.isLogged = false;
    }

}
