//package com.codeup.demo.controller;
//
//import com.codeup.demo.models.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class PostController {
//
////    @RequestMapping(path = "/posts", method = RequestMethod.GET)
////    @ResponseBody
////    public String post1() {
////        return "posts index page";
////    }
//    @GetMapping("/posts/{id}")
//    public String showAd(@PathVariable long id, Model model) {
//        // get by id
//        Post po = new Post("Single ad Title", "Description for a single ad.");
//        model.addAttribute("post", po);
//        return("posts/po");
//    }
//
//    @RequestMapping (path  = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String post2(@PathVariable long id) {
//        return "view an individual post";
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String post3() {
//        return "view the form for creating a post";
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String post4() {
//        return "create a new post";
//    }
//
//}
