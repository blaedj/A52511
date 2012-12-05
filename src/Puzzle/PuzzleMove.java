
package Puzzle;
import framework.Move;
import framework.State;

/**
 *
 * @author Blaed Johnston
 */
public class PuzzleMove extends Move{
    
    /** Constructs a new PuzzleMove Object.
     * @param moveName the name of the move to be constructed. It is an error if the move name is not one of the following:
     * one, two, three, four, five, six, seven
     *
     * */
    public PuzzleMove(String moveName){
        super(moveName);
        Integer i;
        for(i=1; i<9; i++){
            if(!moveName.equals("Tile1") && !moveName.equals("Tile2")
                    && !moveName.equals("Tile3") && !moveName.equals("Tile4")
                    && !moveName.equals("Tile5") && !moveName.equals("Tile6")
                    && !moveName.equals("Tile7") && !moveName.equals("Tile8")){
                System.out.println("Internal error. Invalid move name" + moveName);
            }
        }
    }
    
    @Override
    public State doMove(State otherState) {
        
        PuzzleState state = (PuzzleState) otherState;
        
        String name = getMoveName();
        int tileValueInt = 0;//the int equiv of the value of the tile to be moves
	char tileIntPortion = name.charAt(4);
	switch(tileIntPortion){
	case('1'):
	    tileValueInt = 1;
	    break;
	case('2'):
	    tileValueInt = 2;
	    break;
	case('3'):
	    tileValueInt = 3;
	    break;
	case('4'):
	    tileValueInt = 4;
	    break;
	case('5'):
	    tileValueInt = 5;
	    break;
	case('6'):
	    tileValueInt = 6;
	    break;
	case('7'):
	    tileValueInt = 7;
	    break;
	case('8'):
	    tileValueInt = 8;
	    break;
	default:
	    break;
	}

        SQUARE tileVal = SQUARE.fromInt(tileValueInt);//the actual value of the tile to be moved 
        int posCurrent = state.getLocation(tileVal);//the location on the board of the tile to be moved

        int blankLoc = state.getLocation(SQUARE.BLANK);//the location of the BLANK tile

        if(!adjacent(blankLoc, posCurrent)){
            return null;
        }
        state.setTile(blankLoc, tileVal);//sets the value of the blank tile(at index blankLoc) to value of the tile to move 
        state.setTile(posCurrent, SQUARE.BLANK);//sets the tile place that we moved to blank
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
            System.err.println("invalid adjacent comparator. a = "+a+"b="+b);
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
