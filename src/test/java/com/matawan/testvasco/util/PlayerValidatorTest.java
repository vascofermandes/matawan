package com.matawan.testvasco.util;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerValidatorTest {
    @Test
    public void testIsValidPlayer() {
        assertTrue(PlayerValidator.isValidPlayer("player1", "GK"));
        assertTrue(PlayerValidator.isValidPlayer("player2", "DEF"));
        assertTrue(PlayerValidator.isValidPlayer("player3", "MID"));
        assertTrue(PlayerValidator.isValidPlayer("player4", "FW"));

        assertFalse(PlayerValidator.isValidPlayer("player1", "GoalKeeper"));
        assertFalse(PlayerValidator.isValidPlayer("player2", "Defender"));
        assertFalse(PlayerValidator.isValidPlayer("player3", "MIDfielder"));
        assertFalse(PlayerValidator.isValidPlayer("player4", "abc"));
    }
}