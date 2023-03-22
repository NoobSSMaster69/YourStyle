package org.example.controllers;

import org.example.dao.UserDAOImpl;
import org.example.models.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UsersController {

//    UserDAOImpl personDAOImpl;
//    @Autowired
//    public UsersController(UserDAOImpl personDAOImpl){
//        this.personDAOImpl=personDAOImpl;
//    }
    @Autowired
    UserService userService;
    public UsersController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping()
//    public String peoplePage(Model model){
//        model.addAttribute("people", personDAOImpl.getAllPersons());
//        return "people/index";}

//    @GetMapping("/login")
//    public String loginPage(){
//        return "people/login";
//    }
//    @GetMapping("/registration")
//    public String registrationPage(@ModelAttribute("person") User person){
//        return "people/registration";
//    }

//    @PostMapping("/registration")
//    public String registrationPostPage(@ModelAttribute("person")Person person){
//        person.setPerson_pass();
//        return "people/registration";
//    }


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "people/registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "people/registration";
        }
        if (!userForm.getPassword().equals(userForm.getUserPassConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "people/registration";
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "people/registration";
        }

        return "redirect:/";
    }
}
