package io.hexlet.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getPlayers() {

        Player[] player = new Player[2];
        final Game game = new Game(player, null, null);

        assertEquals(player,game.getPlayers());
    }

    @Test
    void getField() {

        Field field = new Field(3);
        final Game game = new Game(null, field, null);

        assertEquals(field,game.getField());
    }

    @Test
    void getName() {

        String inputValue = "Game1";
        final Game game = new Game(null, null, inputValue);

        assertEquals(inputValue,game.getName());
    }
}