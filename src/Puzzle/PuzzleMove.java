/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;
import framework.Move;
import framework.State;

/**
 *
 * @author blaed
 */
public class PuzzleMove extends Move{

public PuzzleMove(String moveName){
    super(moveName);
    
}
    
    @Override
    public State doMove(State otherState) {
        PuzzleState state = (PuzzleState) otherState;
        if(state.getLocation(SQUARE.BLANK) == 0 || !isValidMove(posCurrent, posMove));
        return null;
        
        
    }


    /** @TODO need to decide how to implement move, what private members etc*/
    
    //find the square to the right, up, down or left
    
    
    /**Takes in two int values and determines if they are adjacent on the board
     * @param a, b the positions on the board to be tested
     * @return returns true if the two are adjacent, false if they are not.
     *  __ __ __
     * | 1  2  3|pp
     * | 4  5  6|
     * |_7 _8 _9|
     * 
     */
    private boolean adjacent(int a, int b){
        if(a < 1 || a > 9||b<1||b>9){
            System.err.println("invalid adjacent comparator");
            return false;
        }
        switch(a){
            case(1):
                return(b == 2 || b==4);
            case(2):
                return(b==1 || b==5 || b==3);
            case(3):
                return(b ==2 || b==6);
            case(4):
                return(b==1 || b==5 || b==7);
            case(5):
                return(b==2||b==4||b==6||b==8);
            case(6):
                return(b==3||b==5||b==9);
            case(7):
                return(b==4||b==8);
            case(8):
                return(b==5||b==7||b==9);
            case(9):
                return(b==6||b==8);
       }
        return false;
    }
    
    /** gets the index of the tile to the right of the current tile.
     * @param curPos the tile whose neighbor is being queried for
     * @return the index of the tile to the right of curPos, or zero if DNE*/
    private int getRightPos(int curPos){
        if(curPos == 3 || curPos == 6 || curPos == 9){
            return 0;
        }
        else{
            return(curPos+1);
        }
    }
    
    /** gets the index of the tile to the left of the current tile, if possible.
     * @param curPos the tile whose neighbor is being queried for
     * @return the index of the tile to the left of curPos, or zero if DNE*/
    private int getLeft(int curPos){
        if(curPos == 1||curPos==4||curPos==7){
            return 0;
        }
        else{
            return curPos++;
        }
    }
    
    /** gets the index of the tile above the current tile, if possible.
     * @param curPos the tile whose neighbor is being queried for
     * @return the index of the tile above curPos, or zero if DNE*/
    private int getAbove(int curPos){
        if(curPos == 1 || curPos == 2 || curPos == 3){
            return 0;
        }
        else{
            return(curPos - 3);
        }
    }
    
    /** gets the index of the tile below the current tile, if possible.
     * @param curPos the tile whose neighbor is being queried for
     * @return the index of the tile below curPos, or zero if DNE*/
    private int getBelow(int curPos){
        if(curPos == 7 || curPos ==8 || curPos == 9){
            return 0;
        }
        else{
            return(curPos + 3);
        }

    }
    
    private boolean isValidMove(int posCurrent, int posMove){
        if(adjacent(posCurrent, posMove)  )
            return true;
        else
        return false;
    }
    
}
