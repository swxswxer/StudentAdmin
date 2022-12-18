package com.swx.service;

import com.swx.pojo.User;

public interface UserService {
    public User login(String username, String password);
    public boolean register(User user);
    void add (User user);
}
