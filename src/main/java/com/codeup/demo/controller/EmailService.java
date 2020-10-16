package com.codeup.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void prepareAndSend(Post post, String title, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getUser().getEmail());
        msg.setSubject(title);
        msg.setText(body);
//        Creating new thread for running the emailsender
        new Thread(new RunnableEmail(this, msg)).start();

        try {
            this.emailSender.send(msg);
        } catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }

}

//Creating Runnable email class so that it runs every time, whenever i create the post
//separating  thread

class RunnableEmail implements Runnable {

//    Created local variable
    private EmailService emailService;
    private SimpleMailMessage message;

    public RunnableEmail(EmailService emailService, SimpleMailMessage message) {
        this.emailService = emailService;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            this.emailService.emailSender.send(message);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}