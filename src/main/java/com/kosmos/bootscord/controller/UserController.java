package com.kosmos.bootscord.controller;

import com.kosmos.bootscord.entities.BootscordUser;
import com.kosmos.bootscord.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService service;

    // Constructor injection
    public UserController(UserService service) {
        this.service = service;
    }

    // Redirects to the homepage (login)
    @GetMapping("/")
    public String showHomePage() {
        return "redirect:/login";
    }

    @PostMapping("/createUser")
    BootscordUser createUser(@RequestBody BootscordUser request) {
        System.out.println("InsideCreateUser!!!!");
        System.out.println(request);
        return service.registerUser(request);
    }

    // Exposes endpoint /login to show login form
    @GetMapping("/login")
    public String showLoginForm() {
        return "login_form";
    }

    // Exposes endpoint /register to show registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Create a new model attribute to bind form data
        model.addAttribute("userForm", new BootscordUser());
        return "register_form";
    }

    // Check for duplicates, return JSON response and save Bootscord user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody BootscordUser user) {
        // Send JSON error if username is taken
        if (service.isDuplicateUserName(user.getUserName())) {
            // Return JSON error response with HTTP 409 (Conflict)
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Username is already taken."));
        }
        // Send JSON error if email is taken
        if (service.isDuplicateEmail(user.getEmail())) {
            // Return JSON error response with HTTP 409 (Conflict)
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Email is already taken."));
        }
        // If all checks passed, save user to database and return HTTP 200 (OK)
        service.registerUser(user);
        return ResponseEntity.ok(Map.of("success", true));
    }

    @GetMapping("/register_result")
    public String showRegisterResult() {
        return "register_result";
    }
}

