package com.codeup.demo.controller;

import com.codeup.demo.repository.PostRepository;
import com.codeup.demo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserRepository adDao;

    public UserController(UserRepository  adDao) {
        this.adDao = adDao;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", adDao.findAll());
        return "users/index";
    }
}
