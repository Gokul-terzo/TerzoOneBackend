package com.terzoOne.terzoOneBackend.service.impl;

import com.terzoOne.terzoOneBackend.models.User;
import com.terzoOne.terzoOneBackend.repository.UserRepository;
import com.terzoOne.terzoOneBackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void deleteUser(String email) {
        User user=userRepository.findByEmail(email).orElseThrow();
        userRepository.delete(user);
    }

    @Override
    public void saveUser(User user) {

    }
}
