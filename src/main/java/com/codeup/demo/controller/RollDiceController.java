package com.codeup.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//This page should display a random number (the dice roll), the user's guess and a message based on whether or not
// they guessed the correct number.
@Controller
class RollDiceController {
    @GetMapping("/roll-dice")
    public String shoRollDice() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        int min = 1;
        int max = 6;
        int random_int = (int) (Math.random() * (max - min + 1) + min);

        String alert = "Sorry! you did not guess the right number";

        if (n == random_int) {
            alert = "Congratulations! you win the game ";
        }

//------------- passing data to the view
        model.addAttribute("random", random_int);
        model.addAttribute("rightGuess", alert);
        return "roll-dice";
    }
}

