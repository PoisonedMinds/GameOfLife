package gameoflife;

import javax.swing.*;

/**
 * @title GameOfLife
 * @author Steven Biro
 * @teacher Mr. J. Carron
 * @date 3-Mar-2015 12:08:54 PM
 * @purpose The purpose of this program is to simulate cell growth
 */
public class GameOfLife {

    public static void main(String[] args) {
        String board[][] = new String[20][20], input;
        int generation = 0;

        //fill he board with dots        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                board[i][j] = ".";
            }
        }
        int cells = 0;
        //get user input for amount of cells to start with
        input = JOptionPane.showInputDialog("The Game Of Life\n Enter and amount "
                + "of cells to start the game with. (Ex. 20)");
        cells = Integer.parseInt(input);
        //put cells on the board
        int col, row;

        for (int i = 0; i < cells; i++) {
            col = (int) (Math.random() * 20);
            row = (int) (Math.random() * 20);
            board[col][row] = "O";
        }

        String continueGame = "";
        while (!continueGame.equals("exit")) {
            //temporary board
            String board2[][] = new String[20][20];

            //display the current board
            System.out.println("----Generation " + generation + "---------------------------");
            generation++;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.print("\n");
            }
            //menu 
            continueGame = JOptionPane.showInputDialog("1 - Next Generation\n" + "exit - Exit the game.");
            if ("1".equals(continueGame)) {
                //propagate neighbours
                int neighbours;
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 20; j++) {
                        neighbours = 0;
                        //assume cells in the next generation is not alive
                        board2[i][j] = ".";
                        //check how many neighbours the cell has
                        if (i > 0 && j > 0) {
                            if (board[i - 1][j - 1].equals("O")) {
                                neighbours++;
                            }
                        }
                        if (i > 0) {
                            if (board[i - 1][j].equals("O")) {
                                neighbours++;

                            }
                        }
                        if (i > 0 && j < 19) {
                            if (board[i - 1][j + 1].equals("O")) {
                                neighbours++;

                            }
                        }
                        if (j > 0) {
                            if (board[i][j - 1].equals("O")) {
                                neighbours++;

                            }
                        }
                        if (j < 19) {
                            if (board[i][j + 1].equals("O")) {
                                neighbours++;

                            }
                        }
                        if (i < 19 && j > 0) {
                            if (board[i + 1][j - 1].equals("O")) {
                                neighbours++;

                            }
                        }
                        if (i < 19) {
                            if (board[i + 1][j].equals("O")) {
                                neighbours++;

                            }
                        }
                        if (i < 19 && j < 19) {
                            if (board[i + 1][j + 1].equals("O")) {
                                neighbours++;

                            }
                        }
                        //determine if the cell in he next generation is alive
                        if (board[i][j].equals("O") && neighbours == 2 || neighbours == 3) {
                            board2[i][j] = "O";

                        }
                        if (board[i][j].equals(".") && neighbours == 3) {
                            board2[i][j] = "O";

                        }
                    }
                }
                //replace board with board2
                board = board2;

            }
        }
    }

}
