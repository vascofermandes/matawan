package com.matawan.testvasco.service.imp;

import com.matawan.testvasco.mock.TeamMock;
import com.matawan.testvasco.model.Position;
import com.matawan.testvasco.model.Team;
import com.matawan.testvasco.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*
Of course is supposed to test all the methods, but for this test purposes and due to time limitations,
I will only implement the test for one of the methods
 */
class TeamServicesImpTest {

    TeamMock input;

    @InjectMocks
    private TeamServicesImp service;

    @Mock
    TeamRepository repository;

    @BeforeEach
    void setUpMocks() throws Exception{
        input = new TeamMock();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        Team entity = input.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);
        assertNotNull(result);

//(number % 2)==0) ? number*20 : number*50);

        assertEquals("Name Test1", result.getName());
        assertEquals("AC1", result.getAcronym());
        assertEquals(50, result.getBudget());
        assertEquals(Position.FW, result.getPlayers().get(1).getPosition());
        assertEquals(Position.DEF, result.getPlayers().get(2).getPosition());

    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }
}