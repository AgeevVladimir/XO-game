package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MoveAdvisorControllerTest {

    @Test
    void getAllAvailablePointsWhenNoAvailableFigures() throws InvalidPointException {

        MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
        final Field field = new Field(3);
        final Point[] availablePoints = new Point[field.getSize()*field.getSize()];

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.X);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        field.setFigure(new Point(2, 0), Figure.O);
        field.setFigure(new Point(2, 1), Figure.O);
        field.setFigure(new Point(2, 2), Figure.O);

        for (int i = 0; i < field.getSize()*field.getSize(); i++)
            assertEquals(availablePoints[i], moveAdvisorController.getAllAvailablePoints(field)[i]);

    }

    @Test
    void getAllAvailablePointsWhenNoFigures() throws InvalidPointException {

        MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
        final Field field = new Field(3);
        final Point[] availablePoints = new Point[field.getSize()*field.getSize()];

        int i = 0;
        for (int x = 1; x < field.getSize()+1; x++) {
            for (int y = 1; y < field.getSize()+1; y++) {
                Point point = new Point(x, y);
                availablePoints[i] = point;
                i++;
            }
        }
 //       System.out.println(Arrays.toString(availablePoints));
 //       System.out.println(Arrays.toString(moveAdvisorController.getAllAvailablePoints(field)));

        for (int j = 0; j < field.getSize()*field.getSize(); j++)
            assertEquals(availablePoints[j], moveAdvisorController.getAllAvailablePoints(field)[j]);

    }
}