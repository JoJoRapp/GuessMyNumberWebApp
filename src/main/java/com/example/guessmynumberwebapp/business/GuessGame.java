package com.example.guessmynumberwebapp.business;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GuessGame {

    private int secret;
    private List<String> replies;
    Random random = new Random();
    boolean completed = false;

    public GuessGame() {
        init();
    }

    private void init() {
        secret = random.nextInt(1,11);
        replies = new ArrayList<>();
    }

    public void makeGuess(int guess) {
        if (completed) {
            init();
            completed = false;
        }

        if (guess < secret) {
            replies.add(guess + ": Too small");
        } else if (guess > secret) {
            replies.add(guess + ": Too large");
        } else {
            replies.add(guess + ": Correct! New game started");
            completed = true;
        }
    }

    public List<String> getReplies() {
        return replies;
    }
}