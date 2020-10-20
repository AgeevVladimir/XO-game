package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        try {
            for (int i = 0; i < 3; i++)
            if (check(field, new Point(i,0), new Point(i,1), new Point(i,2)))
                return field.getFigure(new Point(i,0));

            for (int i = 0; i < 3; i++)
                if (check(field, new Point(0,i), new Point(1,i), new Point(2,i)))
                    return field.getFigure(new Point(0,i));

            if (check(field, new Point(0,0), new Point(1,1), new Point(2,2)))
                return field.getFigure(new Point(1,1));

            if (check(field, new Point(2,0), new Point(1,1), new Point(0,2)))
                return field.getFigure(new Point(1,1));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field, final Point p1, final Point p2, final Point p3) throws InvalidPointException {
        try {
            if (field.getFigure(p1) == null) return false;
            if (field.getFigure(p1) == field.getFigure(p2) &&
                    field.getFigure(p2) == field.getFigure(p3))
                return true;
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return false;

    }

}
