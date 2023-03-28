package com.example.guessmynumberwebapp.presentation;

import com.example.guessmynumberwebapp.business.GuessGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessGameController {

    @Autowired
    private GuessGame guessGame;

    @PostMapping("/guess")
    public String guessForm(@RequestParam int guess, Model m) {
        guessGame.makeGuess(guess);
        m.addAttribute("guessresults", guessGame.getReplies());
        return "guess";
    }

}