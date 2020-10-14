package io.hexlet.xo.model;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    @Test
    void getSize() {

        final int expectedValue = 3;

        final Field field = new Field();

        assertEquals(expectedValue,field.getSize());
    }

    @Test
    void setFigure() {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure,actualFigure);

    }
}