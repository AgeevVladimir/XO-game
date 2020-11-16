package io.hexlet.xo.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbTableCreator {

        public static void main(String[] args) {
            Connection c = null;
            Statement stmt = null;
            String sql = "";
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/postgres",
                                "vova", "123");

                stmt = c.createStatement();

                sql = "CREATE SCHEMA IF NOT EXISTS XO_GAME";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE IF NOT EXISTS XO_GAME.PLAYER"
                        + " ( "
                        + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                        + " NAME                    VARCHAR(32)            NOT NULL, "
                        + " X_WIN_NUM               INTEGER                NOT NULL, "
                        + " O_WIN_NUM               INTEGER                NOT NULL, "
                        + " ) ";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE IF NOT EXISTS XO_GAME.GAME"
                        + " ( "
                        + " ID                      SERIAL PRIMARY KEY     NOT NULL, "
                        + " NAME                    VARCHAR(32)            NOT NULL, "
                        + " PLAYER1_ID              INTEGER                NOT NULL, "
                        + " PLAYER2_ID              INTEGER                NOT NULL, "
                        + " WINNER_ID               INTEGER                NOT NULL  "
                        + " ) ";
                stmt.executeUpdate(sql);

                sql = "ALTER TABLE XO_GAME.GAME "
                        + " ADD CONSTRAINT FK_PLAYER"
                        + " FOREIGN KEY (PLAYER1_ID) REFERENCES XO_GAME.PLAYER (ID) MATCH FULL "
                        + " FOREIGN KEY (PLAYER2_ID) REFERENCES XO_GAME.PLAYER (ID) MATCH FULL "
                        + " ";
                stmt.executeUpdate(sql);

                stmt.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+ e.getMessage());
                System.exit(0);
            }
            System.out.println("Tables are created successfully");
        }

    }
