package com.matawan.testvasco.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

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

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getId() == player.getId() && Objects.equals(getName(), player.getName()) && getPosition() == player.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPosition());
    }
}
