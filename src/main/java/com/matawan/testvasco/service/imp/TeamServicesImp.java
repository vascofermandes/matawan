package com.matawan.testvasco.service.imp;

import com.matawan.testvasco.exception.NotFoundOperationException;
import com.matawan.testvasco.model.Team;
import com.matawan.testvasco.repository.PlayerRepository;
import com.matawan.testvasco.repository.TeamRepository;
import com.matawan.testvasco.service.TeamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TeamServicesImp implements TeamServices {

    private final Logger logger = Logger.getLogger(TeamServicesImp.class.getName());

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Page<Team> findAll(Pageable pageable) {
        logger.info("Finding all the Teams");

        return teamRepository.findAll(pageable);
    }

    @Override
    public Team findById(Long id) {
        logger.info(String.format("Finding Team %s", id));

        return teamRepository.findById(id)
                .orElseThrow(() -> new NotFoundOperationException(String.format("Team with ID=%s not found", id)));
    }

    @Override
    public Team create (Team team) {
        logger.info(String.format("Creating Team %s", team.getName()));

        return teamRepository.save(team);
    }

    @Override
    public void delete(Long id) {
        logger.info(String.format("Deleting Team %s", id));

        teamRepository.deleteById(id);
    }


}
