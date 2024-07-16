package com.matawan.testvasco.model;


import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String acronym;
    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Player> players;
    private int budget;

    public Team(String name, String acronym, List<Player> players, int budget) {
        this.name = name;
        this.acronym = acronym;
        this.players = players;
        this.budget = budget;
    }

    public Team() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcronym() {
        return acronym;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getBudget() {
        return budget;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return getBudget() == team.getBudget() && Objects.equals(getId(), team.getId()) && Objects.equals(getName(), team.getName()) && Objects.equals(getAcronym(), team.getAcronym()) && Objects.equals(getPlayers(), team.getPlayers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAcronym(), getPlayers(), getBudget());
    }
}
