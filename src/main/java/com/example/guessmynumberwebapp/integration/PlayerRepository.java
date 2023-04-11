package com.example.guessmynumberwebapp.integration;

import com.example.guessmynumberwebapp.business.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
}
