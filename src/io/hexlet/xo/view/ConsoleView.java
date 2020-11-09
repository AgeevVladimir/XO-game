package io.hexlet.xo.view;

import io.hexlet.xo.controllers.CurrentMoveController;
import io.hexlet.xo.controllers.MoveController;
import io.hexlet.xo.controllers.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.AlreadyOccupiedException;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.printf("Game name:%s%n", game.getName());
        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            printLine(field, x);
            if (x!=field.getSize()-1) printSeparator();
        }


    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);
        final Figure winner1 = winnerController.getWinner(field);
        if (winner1 != null) {
            System.out.printf("winner is: %s\n", winner1);
            return false;
        }
        if (currentFigure == null) {
            final Figure winner = winnerController.getWinner(field);
            if (winner == null) {
                System.out.println("no winner and no move left");
                return false;
            } else {
                System.out.printf("winner is: %s\n", winner);
                return false;
            }
        }

        // Вызов метода MoveAdvisorController

        System.out.printf("Please enter coordinate for figure %s", currentFigure);
        System.out.println();
        final Point point = askPoint();

        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            e.printStackTrace();
            System.out.println("Point os invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.printf("Enter coordinate %s", coordinateName);
        Scanner in = new Scanner(System.in);
        return in.nextInt();

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
            if (y!=0) System.out.print(" | ");
            System.out.print(figure != null ? figure : " ");
        }
        System.out.println();

    }

    private void printSeparator() {
        System.out.println("----------");
    }

}
