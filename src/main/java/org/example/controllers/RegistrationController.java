package org.example.controllers;

import org.example.dao.UserDAOImpl;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserDAOImpl userDAO;

    @Autowired
    public RegistrationController(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "people/registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "people/registration";
        }
        userDAO.createUser(user);
        return "redirect:/login?success";
    }
}