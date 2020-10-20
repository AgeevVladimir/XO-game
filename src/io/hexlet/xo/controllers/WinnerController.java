package io.hexlet.xo.controllers;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        try {
            for (int i = 0; i < 3; i++)
                if (check(field, new Point(i,0), p -> new Point(p.x, p.y + 1)))
                    return field.getFigure(new Point(i,0));

            for (int i = 0; i < 3; i++)
                if (check(field, new Point(0,i), p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0,i));

            if (check(field, new Point(0,0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(1,1));

            if (check(field, new Point(0,2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1,1));

        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) throws InvalidPointException {
        final Figure currentFigure;
        final Figure nextFugure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFugure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;

        if (currentFigure != nextFugure) return false;

        return check(field, nextPoint, pointGenerator);

        }

    private interface  IPointGenerator {

        public Point next(final Point point);
    }

}
