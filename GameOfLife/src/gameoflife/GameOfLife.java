

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
        String board[][]=new String[20][20], input;
        int generation=0;
        
        //fill he board with dots        
        for(int i = 0;i<20;i++) {
            for (int j=0;j<20;j++) {
                board[i][j]=".";
            }
        }
        int cells=0;
        //get user input for amount of cells to start with
        input=JOptionPane.showInputDialog("The Game Of Life\n Enter and amount "
                + "of cells to start the game with. (Ex. 20)");
        
        //put cells on the board
        int col,row;
        for (int i=0;i<cells;i++) {
            col=(int) (Math.random()*20);
            row=(int) (Math.random()*20);
            board[col][row]="O";
        }
        String continueGame ="";
                while(!continueGame.equals("exit")) {
                    //temporary board
                    String board2[][]=new String[20][20];
                    
                    //display the current board
                    System.out.println("----Generation "+generation+"---------------------------");
                    generation++;
                     for (int i=0;i<20;i++) {
                         for (int j=0;j<20;j++) {
                             System.out.print(board[i][j]);
                         }
                         System.out.print("\n");
                     }
                 
        
                }
        
                
                
                
                
        
    }

}
