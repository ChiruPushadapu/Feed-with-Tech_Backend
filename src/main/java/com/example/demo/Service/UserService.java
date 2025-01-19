package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository; }

    public User registerUser(User user) throws Exception
    {
        if(userRepository.findByUserName(user.getUsername()).isPresent()) {
            throw new Exception("Username already exists");
        }
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email already exists");
        }

        return userRepository.save(user);
    }

    public Optional<User> loginUser(String emailOrUsername, String password)
    {

        Optional<User> user = userRepository.findByEmail(emailOrUsername);
        System.out.println("User found" + user.isPresent());
        if(!user.isPresent()) {
            user = userRepository.findByUserName(emailOrUsername);
        }

        if(user.isPresent()) {
            System.out.println("Password is" + user.get().getPassword());
            System.out.println("Input password is" + password);
            System.out.println("Password matched" + user.get().getPassword().equals(password));
            if(user.get().getPassword().equals(password)) {
                return user;
            }
        }

        return Optional.empty();
    }

    public User updateRole(String userName, String selectedRole) throws Exception {
        Optional<User> optionalUser = userRepository.findByUserName(userName);
        System.out.println("Optional user is   "+ optionalUser.isPresent());
        if(!optionalUser.isPresent()) {
            throw new Exception("User not found");
        }
        User user = optionalUser.get();
        user.setRole(selectedRole);
        return userRepository.save(user);
    }

}
