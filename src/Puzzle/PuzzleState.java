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
    
    SQUARE board[];
/** the board Layout:
     * | 1  2  3|
     * | 4  5  6|  __
     * |_7 _8 _9| |_0| zero is not on the board...
   */ 
    public PuzzleState(String name){
        super(name);
        board = new SQUARE[10];
        initialize();
    }
    
    /**
     * Initializes the state of the board to match the required initial state
     * May need to be changed for various initial states.
     */
    private void initialize(){
        board[1] = SQUARE.TWO;
        board[2] = SQUARE.EIGHT;
        board[3] = SQUARE.THREE;
        board[4] = SQUARE.ONE;
        board[5] = SQUARE.SIX;
        board[6] = SQUARE.FOUR;
        board[7] = SQUARE.SEVEN;
        board[8] = SQUARE.BLANK;
        board[9] = SQUARE.FIVE;
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
            for(int i = 0; i < 9; i++){
                if(this.board[i] != anOther.getBoard()[i]){
                    return false;}
            }//end ouside for()
            return true;
        }
    }//end equals()

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    public SQUARE[] getBoard(){
        return board;
    }
}//end PuzzleState
