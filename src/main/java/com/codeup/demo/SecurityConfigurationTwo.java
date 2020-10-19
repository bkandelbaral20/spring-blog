//package com.codeup.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class SecurityConfigurationTwo extends WebSecurityConfigurerAdapter {
//
//    @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
////    setting configure as an auth object
//        auth.inMemoryAuthentication()
//                .withUser("hello")
//                .password("hello")
//                .roles("USER")
////        if you want to log in with another authorization then add add() method on this object
//                .and()
//                .withUser("hie")
//                .password("heyhey")
//                .roles("ADMin");
//
//    }
//
//    //    for hashing the plain text password
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//    return NoOpPasswordEncoder.getInstance();
//    }
//
//}
