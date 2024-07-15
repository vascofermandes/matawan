package com.matawan.testvasco.controller;

import com.matawan.testvasco.exception.MalformedObjectException;
import com.matawan.testvasco.model.Player;
import com.matawan.testvasco.model.Team;
import com.matawan.testvasco.service.imp.TeamServicesImp;
import com.matawan.testvasco.util.TeamValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamServicesImp teamService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Team>> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size,
            @RequestParam(value = "direction", defaultValue = "asc") String direction,
            @RequestParam(value = "column", defaultValue = "acronym") String column

    ) {
        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, column));
        return ResponseEntity.ok(teamService.findAll(pageable));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Team findById(@PathVariable(value = "id") Long id) {
        return teamService.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Team create(@RequestParam String name,
                       @RequestParam String acronym,
                       @RequestParam int budget,
                       @RequestParam(required = false) List<Player> players){
        if(players == null){
            players = new ArrayList<>();
        }
        if(TeamValidator.isValidTeam(name, acronym, players, budget)){
            Team team = new Team(name, acronym, players, budget);
            return teamService.create(team);
        }
        throw(new MalformedObjectException("Malformed Team"));
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") Long id) {
        teamService.delete(id);
    }
}
