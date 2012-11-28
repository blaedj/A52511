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
    private boolean debug = false;
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
    
    /**
     * Constructs a new PuzzleState. 
     * @param name: the name of the state
     * @param a: an array of SQUARES 
     * @pre a is of size 10, and a[0] == null.
     */
    public PuzzleState(String name, SQUARE a[]){
        super(name);
        //do a deep copy of a into board.
        for(int i=0; i < 9; i++){
            board[i] = a[i];
        }
        if(debug){
            if(a[0] != null)
                System.out.println("a[0] not null error");
        }

    }
    
    /**
     * Initializes the state of the board to match the required initial state
     * May need to be changed for various initial states.
     */
    private void initialize(){
        board[0] = null;
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

    
    /** Setter for any index of board 
     * @param tileLoc the index of the board that is to be changed, must be between 1-9, inclusive.
     * @param val the value to be set
     *@return true if the index was successfully changed, false if tileLoc is outside the acceptable range
     * 
     */
    public boolean setTile(int tileLoc, SQUARE val){
        if(tileLoc < 1 || tileLoc > 9){
            return false;
        }
        else{
            board[tileLoc] = val;
            return true;
        }        
    }//end setTile
    
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
    
    
    public int getLocation(SQUARE s){
        int one = 0;
        
        for (int i = 1; i < 9; i++) {
            if(board[i] == s){
                return i;
            }
        }
        return 0;
    }
}//end PuzzleState
