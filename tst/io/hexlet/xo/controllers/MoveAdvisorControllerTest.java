package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoveAdvisorControllerTest {

    @Test
    void getAllAvailablePointsWhenNoAvailablePoints() throws InvalidPointException {

        MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
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

        final List<Point> allAvailablePoints = moveAdvisorController.getAllAvailablePoints(field);

        assertEquals(0, allAvailablePoints.size());
        assertTrue(allAvailablePoints.isEmpty());

    }

    @Test
    void getAllAvailablePointsWhenNoFigures() throws InvalidPointException {

        MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
        final Field field = new Field(3);

        final List<Point> allAvailablePoints = moveAdvisorController.getAllAvailablePoints(field);

        assertEquals(9, allAvailablePoints.size());

    }

    @Test
    void getAllAvailablePointsWhenSomeFiguresAvailable() throws InvalidPointException {

        MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);


        final List<Point> allAvailablePoints = moveAdvisorController.getAllAvailablePoints(field);
        final List<Point> expextedAvailablePoints = new ArrayList<>();
        expextedAvailablePoints.add(new Point(3,1));
        expextedAvailablePoints.add(new Point(3,2));
        expextedAvailablePoints.add(new Point(3,3));

        assertTrue(allAvailablePoints.equals(expextedAvailablePoints));

    }


}