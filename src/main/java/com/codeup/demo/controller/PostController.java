package com.codeup.demo.controller;

import com.codeup.demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

//    -------------servlets exercises
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String post1() {
        return "posts index page";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String post3() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String post4() {
        return "create a new post";
    }

// ------------View exercises

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable long id, Model model) {
        Post post = new Post(0, "Single Post", "This is the boday for the single post");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        List<Post> postList = new ArrayList<>();
        postList.add(new Post(0, "HTML", "HTML stands for Hyper Text Markup Language"+ " it is the " +
                "standard markup language for creating Web pages, it describes the structure of a Web page"));
        postList.add(new Post(0, "Css", "CSS stands for Cascading Style Sheets\n" +
                "CSS describes how HTML elements are to be displayed on screen, paper, or in other media\n" +
                "CSS saves a lot of work. It can control the layout of multiple web pages all at once\n" +
                "External stylesheets are stored in CSS files\n"));
        postList.add(new Post(0, "SQL", "SQL stands for Structured Query Language\n" +
                "SQL lets you access and manipulate databases\n" +
                "SQL became a standard of the American National Standards Institute (ANSI) in 1986, and of the" +
                " International Organization for Standardization (ISO) in 1987"));
        postList.add(new Post(0, "JavaScript", "JavaScript is the world's most popular programming language.\n" +
                "JavaScript is the programming language of the Web.\n" +
                "JavaScript is easy to learn"));
        postList.add(new Post(0, "Jquery", "jQuery is a lightweight, \"write less, do more\", JavaScript library.\n" +
                "The purpose of jQuery is to make it much easier to use JavaScript on your website." +
                "jQuery takes a lot of common tasks that require many lines of JavaScript code to accomplish, and wraps them into methods that you can call with a single line of code."));
        postList.add(new Post(0, "React", "jQuery is a lightweight, \"write less, do more\", JavaScript library.\n" +
                 "The purpose of jQuery is to make it much easier to use JavaScript on your website.\n" +
                "jQuery takes a lot of common tasks that require many lines of JavaScript code to accomplish, and wraps" +
                " them into methods that you can call with a single line of code."));

        model.addAttribute("posts", postList);
        return "posts/index";
    }
}
