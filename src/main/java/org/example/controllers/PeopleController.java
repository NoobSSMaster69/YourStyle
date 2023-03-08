package org.example.controllers;

import org.example.dao.PersonDAOImpl;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    PersonDAOImpl personDAOImpl;
    @Autowired
    public PeopleController(PersonDAOImpl personDAOImpl){
        this.personDAOImpl=personDAOImpl;
    }

    @GetMapping()
    public String peoplePage(Model model){
        model.addAttribute("people", personDAOImpl.getAllPersons());
        return "people/index";}

    @GetMapping("/login")
    public String loginPage(){
        return "people/login";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")Person person){
        return "people/registration";
    }

//    @PostMapping("/registration")
//    public String registrationPostPage(@ModelAttribute("person")Person person){
//        person.setPerson_pass();
//        return "people/registration";
//    }

}
