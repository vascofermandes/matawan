package com.matawan.testvasco.util;

import com.matawan.testvasco.model.Position;

public class PlayerValidator {

    /**
     * @param name - player name
     * @param pos - player position
     * @return true when all the player params are valid and expected objects
     */
    public static boolean isValidPlayer(String name, String pos) {
        return isValidPosition(pos);
    }

    public static boolean isValidPosition(String pos) {
        Position[] allPositions = Position.values();
        for(Position p: allPositions){
            if(p.name().equals(pos)) return true;
        }
        return false;
    }

}
