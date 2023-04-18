package org.example.service.impl;

import org.example.model.User;

public interface AuthServiceImpl {
    void signup(User user);
    boolean signin(String username, String password);
}
