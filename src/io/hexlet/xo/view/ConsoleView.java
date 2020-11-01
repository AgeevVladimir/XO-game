package io.hexlet.xo.view;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class ConsoleView {

    public void show(final Game game) {
        System.out.printf("Game name:%s%n", game.getName());
        final Field field = game.getField();
        printSeparator();
        for (int x = 0; x < field.getSize(); x++) {
            printLine(field, x);
        }


    }

    public void move(final Game game) {

    }

    private void printLine(final Field field, final int x) {


        for (int y = 0; y < field.getSize(); y++) {
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print("|");
            System.out.print(figure != null ? figure : " ");
        }
        System.out.println("|");
        printSeparator();

    }

    private void printSeparator() {
        System.out.println("-------");
    }

}
