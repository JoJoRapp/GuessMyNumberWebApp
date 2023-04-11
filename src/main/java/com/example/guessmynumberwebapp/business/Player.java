package com.example.guessmynumberwebapp.business;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Result> results = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public Player() {
    }

    public void addResult(int result) {
        results.add(new Result(result));
    }

    public List<Result> getResults() {
        return results;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
