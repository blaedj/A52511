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
    
    /** 
     * De-bugging tool  
     * 
     */
    private boolean debug = false;
    SQUARE[] board = new SQUARE[10];    
    
    @Override
    public String toString() {
        String returnString ="| "+ this.board[1].toString() +"  "+ this.board[2].toString() +"  "+ this.board[3].toString() +"|\n"
                + "| "+ this.board[4].toString() +" "+ this.board[5].toString() +"   "+ this.board[6].toString() +"|\n"
                + "|_"+ this.board[7].toString() +" _"+ this.board[8].toString() +" _"+ this.board[9].toString() +"|\n";
        return returnString;
    }
    

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
    
    /** overloaded constructor to accept one arg, creates the standard 5-move puzzle*/
    public PuzzleState(String name){
        super(name);
        initialize(board);
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
            for(int i = 1; i < 9; i++){
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
    
    private void initialize(SQUARE a[]){
            a[1] = SQUARE.TWO;
            a[2] = SQUARE.EIGHT;
            a[3] = SQUARE.THREE;
            a[4] = SQUARE.ONE;
            a[5] = SQUARE.SIX;
            a[6] = SQUARE.FOUR;
            a[7] = SQUARE.SEVEN;
            a[8] = SQUARE.BLANK;
            a[9] = SQUARE.FIVE;
        }
    
    public SQUARE[] getBoard(){
        return board;
    }
    
    
    public int getLocation(SQUARE s){
        for (int i = 1; i < 9; i++) {
            if(board[i] == s){
                return i;
            }
        }
        return 0;
    }
}//end PuzzleState
