package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CurrentMoveControllerTest {

    @Test
    void currentMoveNextO() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.O, currentMoveController.currentMove(field));
    }

    @Test
    void currentMoveNextX() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(2, 2), Figure.X);
        assertEquals(Figure.X, currentMoveController.currentMove(field));
    }

    @Test
    void currentMoveNoNextMove() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);
        assertNull(currentMoveController.currentMove(field));
    }


    @Test
    void countFiguresInRowTest() throws Exception {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        int row = 0;
        field.setFigure(new Point(0, row), Figure.X);
        field.setFigure(new Point(1, row), Figure.O);
        field.setFigure(new Point(2, row), Figure.O);
        assertEquals(3, currentMoveController.countFiguresInRow(field, row));

    }
}