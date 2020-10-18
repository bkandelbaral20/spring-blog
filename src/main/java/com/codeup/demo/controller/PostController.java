package com.codeup.demo.controller;


import com.codeup.demo.models.EmailService;
import com.codeup.demo.models.Post;
import com.codeup.demo.models.User;
import com.codeup.demo.repositories.PostRepository;
import com.codeup.demo.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class PostController {

//    -------------servlets exercises
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    @ResponseBody
//    public String post1() {
//        return "posts index page";
//    }
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

    //   --------------JPA exercises
    private final PostRepository adDao;
    private final UserRepository userRepo;

    //service exercise
    private final EmailService emailService;

    public PostController(PostRepository adDao, UserRepository userRepo, EmailService emailService) {
        this.adDao = adDao;
        this.userRepo = userRepo;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", adDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        adDao.deleteById(id);
        return "redirect:/posts";

    }

    @GetMapping("/posts/edit/{id}")
    public String EditPost(@PathVariable long id, Model model) {
        model.addAttribute("editPost", adDao.getOne(id));
        return "posts/edit";

    }

    @PostMapping("/posts/edit/{id}")
    public String newEditPost(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = adDao.getOne(id);
        post.setTitle(title);
        post.setBody(body);
        adDao.save(post);
        return "redirect:/posts";
    }


// ------------View exercises

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable long id, Model model) {
        Post post = adDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }


    //    This has all my blogs post about programming languages


//    @RequestMapping(path = "/posts/all", method = RequestMethod.GET)
//    public String showAllPosts(Model model) {
////        List<Post> postList = new ArrayList<>();
////        postList.add(new Post(0, "HTML", "HTML stands for Hyper Text Markup Language"+ " it is the " +
////                "standard markup language for creating Web pages, it describes the structure of a Web page"));
////        postList.add(new Post(0, "Css", "CSS stands for Cascading Style Sheets\n" +
////                "CSS describes how HTML elements are to be displayed on screen, paper, or in other media\n" +
////                "CSS saves a lot of work. It can control the layout of multiple web pages all at once\n" +
////                "External stylesheets are stored in CSS files\n"));
////        postList.add(new Post(0, "SQL", "SQL stands for Structured Query Language\n" +
////                "SQL lets you access and manipulate databases\n" +
////                "SQL became a standard of the American National Standards Institute (ANSI) in 1986, and of the" +
////                " International Organization for Standardization (ISO) in 1987"));
////        postList.add(new Post(0, "JavaScript", "JavaScript is the world's most popular programming language.\n" +
////                "JavaScript is the programming language of the Web.\n" +
////                "JavaScript is easy to learn"));
////        postList.add(new Post(0, "Jquery", "jQuery is a lightweight, \"write less, do more\", JavaScript library.\n" +
////                "The purpose of jQuery is to make it much easier to use JavaScript on your website." +
////                "jQuery takes a lot of common tasks that require many lines of JavaScript code to accomplish, and wraps" +
////                " them into methods that you can call with a single line of code."));
////        postList.add(new Post(0, "React", "jQuery is a lightweight, \"write less, do more\", JavaScript library.\n" +
////                 "The purpose of jQuery is to make it much easier to use JavaScript on your website.\n" +
////                "jQuery takes a lot of common tasks that require many lines of JavaScript code to accomplish, and wraps" +
////                " them into methods that you can call with a single line of code."));
//
//        model.addAttribute("posts", adDao.findAll());
//        return "posts/index";
//    }
//

//    @GetMapping("posts/hardcode/create")
//    public String createHardcodePost() {
//        Post post = new Post();
//        post.setTitle("hello message");
//        post.setBody("hello how are you ? how you are fine?");
//        post.setUser(userRepo.getOne(1L));
//        adDao.save(post);
//        return "redirect:/posts";
//
//    }

// -----------   form binding exercises
//    Change your controller method for showing the post creation form to actually show the form created in the step
//    above. This method should pass a new (i.e. empty) Post object to the view.

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
       User user =  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
       emailService.prepareAndSend(post, "created post: " + post.getTitle() ,
               "Body : " + post.getBody());
        adDao.save(post);
    return "redirect:/posts";
    }


}
