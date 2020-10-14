package io.hexlet.xo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void getName() {

        final String inputValue = "Vovchik";
        final String expectedValue = inputValue;

        final Player player = new Player(inputValue, null);

        final String actlValue = player.getName();

        assertEquals(expectedValue, actlValue);

    }

    @Test
    public void getFigure() {

        final Figure inputValue = Figure.O;
        final Figure expectedValue = inputValue;

        final Player player = new Player(null, inputValue);

        final Figure actualValue = player.getFigure();

        assertEquals(expectedValue, actualValue);

    }
}