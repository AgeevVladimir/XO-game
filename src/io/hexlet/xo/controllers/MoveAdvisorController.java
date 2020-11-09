package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveAdvisorController {

    public Point[] getAllAvailablePoints(final Field field)
            throws InvalidPointException {

        int i = 0;
        final Point[] availablePoints = new Point[field.getSize()];
        for (int x = 0; x < field.getSize(); x++) {
            for (int y = 0; y < field.getSize(); y++) {
                Point point = new Point(x, y);
                if (field.getFigure(point) != null) {

                    availablePoints[i] = point;
                    i++;
                }
            }
        }
        return null;

    }

}