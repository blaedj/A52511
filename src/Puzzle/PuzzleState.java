/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import framework.State;
import graph.SimpleVertex;
/**
 *
 * @author Blaed Johnston
 */
public class PuzzleState extends SimpleVertex implements State{

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public enum SQUARE {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, BLANK}
    
    SQUARE board[][];
    
    public PuzzleState(String name){
        super(name);
        board = new SQUARE[3][3];
        initialize();
    }
    
    /**
     * Initializes the state of the board to match the required initial state
     * May need to be changed for vaious initial states.
     */
    private void initialize(){
        board[0][0] = SQUARE.TWO;
        board[0][1] = SQUARE.EIGHT;
        board[0][2] = SQUARE.THREE;
        board[1][0] = SQUARE.ONE;
        board[1][1] = SQUARE.SIX;
        board[1][2] = SQUARE.FOUR;
        board[2][0] = SQUARE.SEVEN;
        board[2][1] = SQUARE.BLANK;
        board[2][2] = SQUARE.FIVE;
    }
    
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }
        else{
            PuzzleState anOther = (PuzzleState) other;
            
            for(int i = 0; i < 3; i++){
                for(int j =0; j < 3; j++){
                    if(this.board[i][j] != anOther.getBoard()[i][j]){
                        return false;
                    }
                }//end nested for
            }//end ouside for()
            return true;
        }
    }//end equals()

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    public SQUARE[][] getBoard(){
        return board;
    }
}//end PuzzleState
