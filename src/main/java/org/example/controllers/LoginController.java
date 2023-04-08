package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.dao.ProductDAOImpl;
import org.example.dao.UserDAOImpl;
import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @GetMapping("/login")
        public String showLoginPage(@RequestParam(name = "error", required = false) String error,
                                    @RequestParam(name = "logout", required = false) String logout, Model model) {
            if (error != null) {
                model.addAttribute("error", "Invalid username and/or password");
            }
            if (logout != null) {
                model.addAttribute("message", "You have been logged out successfully");
            }
            return "people/login";
        }

    @PostMapping("/login")
    public String login(@RequestParam("userLogin") String userLogin,
                        @RequestParam("userPass") String userPass,
                        RedirectAttributes redirectAttributes, HttpServletRequest request) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogin, userPass));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "redirect:/";
        } catch (BadCredentialsException ex) {
            redirectAttributes.addFlashAttribute("error", "Invalid username and/or password");

            return "redirect:/login";
        }
    }
}
