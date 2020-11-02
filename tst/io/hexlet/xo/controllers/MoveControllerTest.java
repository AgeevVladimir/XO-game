package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
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

}