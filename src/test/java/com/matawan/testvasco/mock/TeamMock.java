package com.matawan.testvasco.mock;

import com.matawan.testvasco.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamMock {

    public Team mockEntity() {
        return mockEntity(0);
    }

    public List<Team> mockEntityList() {
        List<Team> Teams = new ArrayList<Team>();
        for (int i = 0; i < 9; i++) {
            Teams.add(mockEntity(i));
        }
        return Teams;
    }
    

    public Team mockEntity(Integer number) {
        Team Team = new Team();
        Team.setName("Name Test" + number);
        Team.setAcronym("AC" + number);
        Team.setBudget(((number % 2)==0) ? number*20 : number*50);
        Team.setPlayers(PlayerMock.mockEntityList(number));
        return Team;
    }


}
