package com.matawan.testvasco.util;

import com.matawan.testvasco.model.Player;

import java.util.List;

public class TeamValidator {

    public static boolean isValidTeam(String name, String acronym, List<Player> players, int budget){
        for(Player p: players){
            if(!PlayerValidator.isValidPlayer(p.getName(), p.getPosition().toString())) {
                return false;
            }
        }
        return true;
    }
}
