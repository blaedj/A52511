
package Puzzle;
import framework.Move;
import framework.State;

/**
 *
 * @author blaed
 */
public class PuzzleMove extends Move{
    
    /** Constructs a new PuzzleMove Object.
     * @param moveName the name of the move to be constructed. It is an error if the move name is not one of the following:
     * 1Left
     * 1Right
     * 1Up
     * 1Down...
     * .
     * .
     * .and so on for 1, 2, 3, 4, 5, 6, 7, 8*/
    public PuzzleMove(String moveName){
        super(moveName);
        Integer i;
        for(i=1; i<9; i++){
            if(!moveName.equals(i.toString() + "Up")||!moveName.equals(i.toString() + "Down")
                    ||!moveName.equals(i.toString() + "Left")
                    ||!moveName.equals(i.toString() + "Right")){
                System.out.println("Invalid moveName. Internal Error.");
            }
        }
    }
    
    @Override
    public State doMove(State otherState) {

        PuzzleState state = (PuzzleState) otherState;

        String name = getMoveName();
        int tileValueInt = name.charAt(0);//the int equiv of the value of the tile to be moves
        String direction = name.substring(1);//the direction that the tile is to be moved
        SQUARE tileVal = SQUARE.fromInt(tileValueInt);//the actual value of the tile to be moved
        int posCurrent = state.getLocation(tileVal);//the location on the board of the tile to be moved
        int posMove = getDirectedPos(direction, posCurrent);//the index of the desired final tile location
        int blankLoc = state.getLocation(SQUARE.BLANK);//the location of the BLANK tile
        if(state.getLocation(SQUARE.BLANK) == 0 || !adjacent(posCurrent, posMove)){
            return null;
        }
        
        state.setTile(blankLoc, tileVal);
        state.setTile(posCurrent, tileVal);
        return state;
    }
    
    
    /** @TODO need to decide how to implement move, what private members etc*/
    
       /**Takes in two int values and determines if they are adjacent on the board
     * @param a, b the positions on the board to be tested
     * @return returns true if the two are adjacent, false if they are not.
     *  __ __ __
     * | 1  2  3|
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
    
    
    /** Decides which get(direction)Pos to call and calls if
     * @param direction the direction of the value being queried for
     * @param curPos the location of the starting tile
     * @return the location of the tile to the right, left, up or down of the tile,
     * returns 0 as an error message.
     */
    private int getDirectedPos(String direction, int curPos){
        switch(direction){
            case("Right"):
                return getRight(curPos);
            case("Left"):
                return getLeft(curPos);
            case("Up"):
                return getAbove(curPos);
            case("Down"):
                return getBelow(curPos);
            default:
                return 0;
        }
    }
    
    
    /** gets the index of the tile to the right of the current tile.
     * @param curPos the tile whose neighbor is being queried for
     * @return the index of the tile to the right of curPos, or zero if DNE*/
    private int getRight(int curPos){
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
    
    private void swapBlank(int curPos, int movePos, SQUARE curVal){
        
        
    }

}
