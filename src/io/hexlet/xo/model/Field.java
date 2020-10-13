package io.hexlet.xo.model;

import java.awt.*;

public class Field {

    private static final int FIELD_SIZE = 3;

    private final Figure[][] field = new Field[FIELD_SIZE][FIELD_SIZE];

    public int getSize(){
        int fieldSize = FIELD_SIZE;
        return fieldSize;
    }

    public Figure getFigure(final Point point){

        Figure figure = field[point.x][point.y];
        return figure;

    }

    public void setFigure(final Point point, final Figure figure){

        field[point.x][point.y] = figure;

    }
}
