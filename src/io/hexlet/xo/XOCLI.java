package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.view.ConsoleView;

import java.awt.*;

public class XOCLI {

    public static void main(final String[] args) throws InvalidPointException {
        final String name1 = "Vovchik";
        final String name2 = "Vovan";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        Field field = new Field(3);
//        field.setFigure(new Point(0,0), Figure.X);
//        field.setFigure(new Point(0,1), Figure.O);
//        field.setFigure(new Point(1,2), Figure.X);
//        field.setFigure(new Point(1,0), Figure.O);
//        field.setFigure(new Point(2,0), Figure.X);
//        field.setFigure(new Point(2,1), Figure.O);


        final Game game = new Game(players, field, "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game)){
            consoleView.show(game);
        }


    }
}
