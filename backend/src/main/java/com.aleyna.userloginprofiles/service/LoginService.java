package com.aleyna.userloginprofiles.service;

import com.aleyna.userloginprofiles.entity.User;
import com.aleyna.userloginprofiles.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String tcKimlikNo, String password) {
        Optional<User> optionalUser = userRepository.findByTcKimlikNo(tcKimlikNo);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
}
