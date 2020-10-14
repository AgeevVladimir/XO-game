package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
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
    void setFigure() throws InvalidPointException, AlreadyOccupiedException {

        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);

    }

    @Test
    void getFigureWhenFigureIsNotSetted() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    void getFigureWhenXIsLessThenZero() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(-1,0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void getFigureWhenYIsLessThenZero() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,-2);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void getFigureWhenXIsMoreThenSize() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize()+1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void getFigureWhenYIsLessThenSize() throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,field.getSize()+1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    void setFigureWhenAlreadyOcupied () throws Exception{
        final Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }
}