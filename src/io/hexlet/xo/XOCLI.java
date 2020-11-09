package io.hexlet.xo;

import io.hexlet.xo.controllers.MoveAdvisorController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.view.ConsoleView;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class XOCLI {

    public static void main(final String[] args) throws InvalidPointException {
        final String name1 = "Vovchik";
        final String name2 = "Vovan";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        Field field = new Field(3);
        field.setFigure(new Point(0,0), Figure.X);
        field.setFigure(new Point(0,1), Figure.O);
        field.setFigure(new Point(1,2), Figure.X);
        field.setFigure(new Point(1,0), Figure.O);
        field.setFigure(new Point(2,0), Figure.X);
        field.setFigure(new Point(2,1), Figure.O);

        final Point[] availablePoints;

        final Game game = new Game(players, field, "XO");
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);

        final MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
        availablePoints = moveAdvisorController.getAllAvailablePoints(field);
        System.out.println(Arrays.toString(moveAdvisorController.getAllAvailablePoints(field))); // Некрасиво выводит

        System.out.println("Available points");
        for (int i = 0; i < 9; i++){
            if(availablePoints[i] != null){
                System.out.print("X: " + availablePoints[i].x);
                System.out.println(", Y: " + availablePoints[i].y);
            }
        }
        }

/*
        final MoveAdvisorController moveAdvisorController = new MoveAdvisorController();
        System.out.println(Arrays.toString(moveAdvisorController.getAllAvailablePoints(field)));
*/

//        while (consoleView.move(game)){
//            consoleView.show(game);
//        }


    }

