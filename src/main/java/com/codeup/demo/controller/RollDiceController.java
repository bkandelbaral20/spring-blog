package com.codeup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//This page should display a random number (the dice roll), the user's guess and a message based on whether or not
// they guessed the correct number.
@Controller
class RollDiceController {

    @GetMapping("/roll-dice/n")
    @ResponseBody
    public static void main( String args[] ) {
        int min = 1;
        int max = 6;
        //Generate random int value from 1 to 6
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        System.out.println(random_int);
    }
}
