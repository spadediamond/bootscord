package com.kosmos.bootscord.controller;

import com.kosmos.bootscord.entities.BootscordUser;
import com.kosmos.bootscord.repos.UserRepository;
import com.kosmos.bootscord.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private UserServiceImpl userServiceImpl;

    // Constructor injection
    @Autowired
    public RegisterController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    // Exposes endpoint /register to show registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Create a model attribute to bind form data
        BootscordUser user = new BootscordUser();

        model.addAttribute("user", user);
        return "register_page";
    }

    // Process the form and save the Bootscord user
    @PostMapping("/register/registerUser")
    public String registerUser(@ModelAttribute("user") BootscordUser user) {
        // Save user to database
        userServiceImpl.registerUser(user);

        // Redirect to login page to prevent duplicate submissions
        return "redirect:/";
    }
}





//    @PostMapping("/register")
//    public ResponseEntity<String> processRegisterForm(@ModelAttribute BootscordUser user) {
//
//    }}
