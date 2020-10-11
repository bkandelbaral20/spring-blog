package com.codeup.demo.controller;

import com.codeup.demo.controller.Post;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false,  length = 100)
    private String date;

    @Column(nullable = false, length = 100)
    private String facebookId;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public User() {
    }

    public User(long id, String username, String email, String password, String date, String facebookId, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.date = date;
        this.facebookId = facebookId;
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
}
