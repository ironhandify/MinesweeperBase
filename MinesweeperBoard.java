
/**
 * Write a description of class MinesweeperBoard3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MinesweeperBoard{
    Cell[] board;
    int rows;
    int columns;
    boolean number = false;
    public MinesweeperBoard(int row, int column){
        //Put the constructor here.

        this.rows = row;
        this.columns = column;
        board = new Cell[rows*columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());
        addNums();
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public MinesweeperBoard(){
        this(10,10);
    }

    public void addBombs(int bombs) {//throws Exception{

        for(int r = 0; r < bombs; r ++){
            boolean placed = false;

            while (!placed){
                int rand = (int)(Math.random() * (rows*columns) - 1);
                if (board[rand].getValue() == 0){
                    board[rand].setBomb();
                    placed = true;
                }
            }

        }

    }

    public void addNums(){
        int total = (rows * columns);

        for ( int r = 0; r < total; r++){

            if (board[r].getValue() != -1){
                if(r == 0){
                    //bot//Add a && statement here
                    if (board[r + columns].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot-right
                    if (board[r + columns + 1].getValue() == -1){
                        board[r].setValue();
                    }

                    //right
                    if (board[r + 1].getValue() == -1){
                        board[r].setValue();
                    }
                }else if (r == columns - 1){
                    //bot-left
                    if (board[r + columns -1].getValue() == -1){
                        board[r].setValue();
                    }

                    //bot
                    if (board[r + columns].getValue() == -1){
                        board[r].setValue();
                    }

                    //left
                    if (board[r - 1].getValue() == -1){
                        board[r].setValue();
                    }
                }else if (r == rows*columns - columns){
                    //top-right//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }

                    //top//
                    if ((board[r - columns]).getValue() == -1){
                        board[r].setValue();
                    }

                    //right
                    if (board[r + 1].getValue() == -1){
                        board[r].setValue();
                    }
                }else if(r == rows*columns-1){
                    //left
                    if (board[r - 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //top-left//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //top//
                    if ((board[r - columns]).getValue() == -1){
                        board[r].setValue();
                    }
                } else if(r < columns){
                    //left
                    if (board[r - 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //right
                    if (board[r + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot
                    if (board[r + columns].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot-left
                    if (board[r + columns -1].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot-right
                    if (board[r + columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                }
                else if(r % columns == columns -1){
                    //top-left//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                     //left
                    if (board[r - 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot-left
                    if (board[r + columns -1].getValue() == -1){
                        board[r].setValue();
                    }
                     //bot
                    if (board[r + columns].getValue() == -1){
                        board[r].setValue();
                    }
                    //top//
                    if ((board[r - columns]).getValue() == -1){
                        board[r].setValue();
                    }
                }
                else if (r > rows*columns - columns){
                    //top//
                    if ((board[r - columns]).getValue() == -1){
                        board[r].setValue();
                    }
                    //top-left//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //top-right//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                }
                else if(( r % columns) == 0){
                    //top-right//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //top//
                    if ((board[r - columns]).getValue() == -1){
                        board[r].setValue();
                    }
                    //right
                    if (board[r + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot
                    if (board[r + columns].getValue() == -1){
                        board[r].setValue();
                    }
                     //bot-right
                    if (board[r + columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                }else{
                    //add everything
                     //bot-right
                    if (board[r + columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //top-left//
                    if (board[r - columns + 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //right
                    if (board[r + 1].getValue() == -1){
                        board[r].setValue();
                    }
                     //left
                    if (board[r - 1].getValue() == -1){
                        board[r].setValue();
                    }
                    //bot-left
                    if (board[r + columns -1].getValue() == -1){
                        board[r].setValue();
                    }
                     //bot
                    if (board[r + columns].getValue() == -1){
                        board[r].setValue();
                    }
                    //top//
                    if ((board[r - columns]).getValue() == -1){
                        board[r].setValue();
                    }
                }

            }
        }
    }


    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int index  = 0;
        int c = 0;
        for (int r = 0; r < rows; r++){
            while(c < columns){
                c++;
                if (board[index].getValue() == -1){
                    System.out.print("X ");
                }else{
                    System.out.print(board[index].getValue() + " ");
                }
                index ++;

            }
            System.out.println();
            c = 0;
        }
    }

    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            board[i]= new Cell();
            panel.add(board[i].getButton());
        }
        return panel;
    }

}

