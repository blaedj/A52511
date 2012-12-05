package Puzzle;

import framework.State;
import graph.SimpleVertex;
import java.util.ArrayList;
import java.util.Arrays;
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
    private ArrayList<SQUARE> board = new ArrayList<>();
    
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
    public PuzzleState(ArrayList<SQUARE> a){
        //do a deep copy of a into board.
        board = new ArrayList<>(10);
        for(int i=0; i < 9; i++){
            board.add(a.get(i));
        }
    }
    
    /** overloaded constructor w/ no args creates the standard 5-move puzzle*/
    public PuzzleState(){
        board = initialize();
    }
    
    /**
     * Overloaded contructor, probably the one that will get the most use
     * @param the values of the 1-9 indices of the board matrix, they represent the value of each tile in order
     */
    public PuzzleState(int one, int two, int three, int four, int five, int six, int seven, int eight, int nine){
       
        board.add(SQUARE.EMPTY);
        board.add(SQUARE.fromInt(one));
        board.add(SQUARE.fromInt(two));
        board.add(SQUARE.fromInt(three));
        board.add(SQUARE.fromInt(four));
        board.add(SQUARE.fromInt(five));
        board.add(SQUARE.fromInt(six));
        board.add(SQUARE.fromInt(seven));
        board.add(SQUARE.fromInt(eight));
        board.add(SQUARE.fromInt(nine));
    }
    
    @Override
    public String toString() {

        String stringState = "| "+ this.getBoard().get(1).toString() +"  "+ this.getBoard().get(2).toString() +"  "+ this.getBoard().get(3).toString() +"|\n"
                + "| "+ this.getBoard().get(4).toString() +" "+ this.getBoard().get(5).toString() +"   "+ this.getBoard().get(6).toString() +"|\n"
                + "|_"+ this.getBoard().get(7).toString() +" _"+ this.getBoard().get(8).toString() +" _"+ this.getBoard().get(9).toString() +"|\n";
        
        return stringState;
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
            board.set(tileLoc, val);
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
            for(int i = 1; i < 10; i++){
                if(this.board.get(i) != anOther.getBoard().get(i)){
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
    
    private ArrayList<SQUARE> initialize(){
        ArrayList<SQUARE> a = new ArrayList<>(10);
        a.add(SQUARE.EMPTY);
        a.add(SQUARE.TWO);
        a.add(SQUARE.EIGHT);
        a.add(SQUARE.THREE);
        a.add(SQUARE.ONE);
        a.add(SQUARE.SIX);
        a.add(SQUARE.FOUR);
        a.add(SQUARE.SEVEN);
        a.add(SQUARE.BLANK);
        a.add(SQUARE.FIVE);
        
        return a;
    }
    
    public ArrayList<SQUARE> getBoard(){
        return board;
    }
    
    
    /**
     * 
     * @param s the value of the tile whose index we want to find
     * @return the index of the tile with value s, or -1 if not found.
     */
    public int getLocation(SQUARE s){
        for (int i = 1; i < 10; i++) {
            SQUARE sq = board.get(i);
            if(sq.equals(s)){
                return i;
            }
        }
                
        return -1;
        /**should never get here, else something has gone wrong in
         * the initialization of board, since all tiles should be
         * included every time.
         */
    }
}//end PuzzleState
