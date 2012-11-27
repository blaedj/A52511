/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import framework.State;

/**
 *
 * @author Blaed Johnston
 */
public class PuzzleState implements State{

    public enum SQUARE {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, BLANK}
    
    SQUARE board[][];
    
    public PuzzleState(){
        board = new SQUARE[3][3];
        initialize();
    }
    
    private void initialize(){
        board[0][0] = SQUARE.ONE;
        board[0][1] = SQUARE.TWO;
        board[0][2] = SQUARE.THREE;
        board[1][0] = SQUARE.FOUR;
        board[1][1] = SQUARE.FIVE;
        board[1][2] = SQUARE.SIX;
        board[2][0] = SQUARE.SEVEN;
        board[2][1] = SQUARE.EIGHT;
        board[2][2] = SQUARE.BLANK;
    }
    
    @Override
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        else if(other.getClass() != this.getClass()){
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
