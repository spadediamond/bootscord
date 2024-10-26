package com.kosmos.bootscord.controller;

import com.kosmos.bootscord.entities.BootscordUser;
import com.kosmos.bootscord.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserService service;

    // Constructor injection
    public UserController(UserService service) {
        this.service = service;
    }

    // Find a better way to make login page default..?
    @GetMapping("/")
    public RedirectView redirectToLoginForm() {
        return new RedirectView("/login");
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
        return "login_page";
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
    public RedirectView registerUser(@ModelAttribute("user") BootscordUser user) {
        // Save user to database
        service.registerUser(user);

        // Redirect to login page to prevent duplicate submissions
        return new RedirectView("redirect:/registrationSuccess");
    }

    // Expose endpoint /registrationSuccess to expose registration success page
    @GetMapping("/registrationSuccess")
    public String showRegistrationSuccess() {
        return "registration_success";
    }
}

