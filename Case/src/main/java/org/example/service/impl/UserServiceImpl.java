package org.example.service.impl;


import org.example.model.User;

import java.util.List;

public interface UserServiceImpl {
    List<User> getListUser();
    User getUserDetail(int userId);
    User getUserDetailByUsername(String userName);
    void add(User newUser);
    boolean update(int userId, User updtUser);
    boolean delete(int userId);
}
