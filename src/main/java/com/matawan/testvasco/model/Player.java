package com.matawan.testvasco.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name="position")
    Position position;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Player() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
