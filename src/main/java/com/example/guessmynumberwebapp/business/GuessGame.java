package com.example.guessmynumberwebapp.business;

import com.example.guessmynumberwebapp.integration.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GuessGame {

    @Autowired
    private PlayerRepository playerRepository;
    private int secret;
    private List<String> replies;
    private Player player;
    Random random = new Random();
    boolean completed = false;

    public GuessGame() {
        init();
    }

    private void init() {
        secret = random.nextInt(1,11);
        replies = new ArrayList<>();
    }

    public void login(String name) {
        Player existingPlayer = playerRepository.findByName(name);
        if (existingPlayer == null) {
            playerRepository.save(new Player(name));
        }
        player = playerRepository.findByName(name);
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
            player.addResult(replies.size());
            player = playerRepository.save(player);
            completed = true;
        }
    }

    public List<String> getReplies() {
        return replies;
    }

    public List<PlayerAverage> getAverageScores() {
        List<Player> allPlayers = playerRepository.findAll();
        List<PlayerAverage> playerAverages = new ArrayList<>();

        for (Player p : allPlayers) {
            List<Result> results = p.getResults();
            double average = 0d;

            for (Result r : results) {
                average += r.getValue();
            }

            average /= results.size();
            playerAverages.add(new PlayerAverage(p.getName(), average));
        }

        playerAverages.sort(Comparator.comparingDouble(PlayerAverage::getAverage));
        return playerAverages;
    }

    public Player getPlayer() {
        return player;
    }
}