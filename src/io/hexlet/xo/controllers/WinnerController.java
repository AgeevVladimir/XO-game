package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        try {
            if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(0, 1)) &&
                    field.getFigure(new Point(0, 1)) == field.getFigure(new Point(0, 2)))
                return field.getFigure(new Point(0, 0));
            if (field.getFigure(new Point(1, 0)) == field.getFigure(new Point(1, 1)) &&
                    field.getFigure(new Point(1, 1)) == field.getFigure(new Point(1, 2)))
                return field.getFigure(new Point(1, 1));
            if (field.getFigure(new Point(2, 0)) == field.getFigure(new Point(2, 1)) &&
                    field.getFigure(new Point(2, 1)) == field.getFigure(new Point(2, 2)))
                return field.getFigure(new Point(2, 2));
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

}
