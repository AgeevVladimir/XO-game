package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MoveAdvisorController {

    public List<Point> getAllAvailablePoints(final Field field)
            throws InvalidPointException {

        List<Point> availablePoints = new ArrayList<>();
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {

                if (field.getFigure(new Point(x, y)) == null) {

                    availablePoints.add(new Point(x+1, y+1));

                }
            }
        }
        return availablePoints;

    }

}