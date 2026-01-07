package com.aleyna.userloginprofiles.service;

import com.aleyna.userloginprofiles.entity.User;
import com.aleyna.userloginprofiles.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ----------------- Kayıt ve Giriş -----------------
    public boolean register(User user) {
        Optional<User> existingUser = userRepository.findByTcKimlikNo(user.getTcKimlikNo());
        if (existingUser.isPresent()) {
            return false; // zaten var
        }
        userRepository.save(user);
        return true;
    }

    public boolean login(String tcKimlikNo, String password) {
        Optional<User> optionalUser = userRepository.findByTcKimlikNo(tcKimlikNo);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getPassword().equals(password);
        }
        return false;
    }

    // ----------------- Kullanıcı Yönetimi -----------------
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setPassword(updatedUser.getPassword());
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
