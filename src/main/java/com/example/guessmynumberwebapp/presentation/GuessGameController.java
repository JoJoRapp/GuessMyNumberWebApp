package com.example.guessmynumberwebapp.presentation;

import com.example.guessmynumberwebapp.business.GuessGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessGameController {

    @Autowired
    private GuessGame guessGame;

    @GetMapping("/guessgame")
    public String guessGame() {
        if (guessGame.getPlayer() == null) {
            return "redirect:/login.html";
        } else {
            return "guess";
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String name) {
        guessGame.login(name);
        return "guess";
    }

    @PostMapping("/guess")
    public String guessForm(@RequestParam int guess, Model m) {
        guessGame.makeGuess(guess);
        m.addAttribute("guessresults", guessGame.getReplies());
        return "guess";
    }

    @GetMapping("/scores")
    public String scores(Model m) {
        m.addAttribute("averageScores", guessGame.getAverageScores());
        return "scores";
    }

}