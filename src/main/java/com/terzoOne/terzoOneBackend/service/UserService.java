package com.terzoOne.terzoOneBackend.service;

import com.terzoOne.terzoOneBackend.models.User;

public interface UserService {
    void deleteUser(String email);
    void saveUser(User user);
}
