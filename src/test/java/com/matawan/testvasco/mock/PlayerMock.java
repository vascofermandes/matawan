package com.matawan.testvasco.mock;

import com.matawan.testvasco.model.Player;
import com.matawan.testvasco.model.Position;

import java.util.ArrayList;
import java.util.List;

public class PlayerMock {

    public Player mockEntity() {
        return mockEntity(0, 0);
    }

    public static List<Player> mockEntityList(Integer teamNumber) {
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < 9; i++) {
            players.add(mockEntity(i, teamNumber));
        }
        return players;
    }
    

    public static Player mockEntity(Integer playerNumber, Integer teamNumber) {
        Player player = new Player();
        player.setName("Name Player" + teamNumber + playerNumber);
        player.setPosition(((playerNumber % 2)==0) ? Position.DEF : Position.FW);
        return player;
    }


}
