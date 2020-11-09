package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MoveControllerTest {

    @Test
    void moveControllerTestSuccess() throws Exception {
        final MoveController moveController = new MoveController();
        final Field field = new Field(3);
        final Point point = new Point(0,0);
        final Figure figure = Figure.X;

        moveController.applyFigure(field, point, figure);
        assertEquals(field.getFigure(point), figure);

    }


    @Test
    public void moveControllerTestWhenPointInvalid() {
        final MoveController moveController = new MoveController();
        final Field field = new Field(3);
        final Point point = new Point(0,6);
        final Figure figure = Figure.X;

        Exception exception = assertThrows(InvalidPointException.class, () -> {
            moveController.applyFigure(field, point, figure);
        });

        String expectedMessage = "Point is invalid";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void moveControllerTestWhenAlreadyOccupied() throws InvalidPointException {
        final MoveController moveController = new MoveController();
        final Figure figure = Figure.X;
        final Point point = new Point(0,0);

        final Field field = new Field(3);
        field.setFigure(new Point(0, 0), Figure.X);

        Exception exception = assertThrows(AlreadyOccupiedException.class, () -> {
            moveController.applyFigure(field, point, figure);
        });

        String expectedMessage = "Point is Occupied";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}