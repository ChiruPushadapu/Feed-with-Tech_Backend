package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.lang.annotation.Repeatable;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) throws Exception {
        try {
            System.out.println("Inside controller"+user);
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> payload)
    {
        try {
            String emailOrUserName = payload.get("emailOrUsername");
            String password = payload.get("password");
            Optional<User> user = userService.loginUser(emailOrUserName, password);
            if(user.isPresent())
            {
                return new ResponseEntity<>("User Logged In successfully", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("Invalid email/username or password", HttpStatus.UNAUTHORIZED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/roleSelection")
    public ResponseEntity<String> updateRole(@RequestBody Map<String, String> payload)
    {
        try{
            String userName = payload.get("username");
            String selectedRole = payload.get("role");
            System.out.println("Payload is" + payload);
            userService.updateRole(userName, selectedRole);
            return new ResponseEntity<>("Role Updated Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
