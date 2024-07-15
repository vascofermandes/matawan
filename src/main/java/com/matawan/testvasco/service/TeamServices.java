package com.matawan.testvasco.service;

import com.matawan.testvasco.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamServices {

    Page<Team> findAll(Pageable pageable);

    Team findById(Long id);
    Team create(Team team);

    void delete(Long id);

}
