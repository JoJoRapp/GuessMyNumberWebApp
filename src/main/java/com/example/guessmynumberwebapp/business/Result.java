package com.example.guessmynumberwebapp.business;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private Long id;

    private int value;

    public Result(int value) {
        this.value = value;
    }

    public Result() {
    }

    public int getValue() {
        return value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
