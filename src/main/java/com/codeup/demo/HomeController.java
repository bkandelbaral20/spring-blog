package com.codeup.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String landingMessage() {
        return "<h1>This is the landing page!</h1>";
    }
}
