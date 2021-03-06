package com.codeup.demo.models;


import com.codeup.demo.models.User;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;


//    @Column(nullable = false,  length = 100)
//    private Date date;

    @ManyToOne
    @JoinColumn (name = "user_id")
//    user property for tracking users
    private User user;

    public Post(){}

    public Post(long id, String title, String body,  User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
