package waterjug;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the Water Jug problem.
 * A move object stores its move name and knows how to apply itself
 * to a water jug state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * @author your name here
*/
public class WaterJugMove extends Move {

    /**
     * Constructs a new water jug move object.
     * Note that the move name is passed to the parent constructor
     * using <b>super</b>.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "Fill Jug X" </li>
     * <li> "Fill Jug Y" </li>
     * <li> "Empty Jug X" </li>
     * <li> "Empty Jug Y" </li>
     * <li> "Transfer Jug X to Jug Y" </li>
     * <li> "Transfer Jug Y to Jug X" </li>
     * </ul>
     */
    public WaterJugMove(String moveName) {
	super(moveName);
        if(getMoveName().equals("Fill Jug X")
                || getMoveName().equals("Fill Jug Y") 
                || getMoveName().equals("Empty Jug X")
                || getMoveName().equals("Empty Jug Y")
                || getMoveName().equals("Transfer Jug X to Jug Y")
                || getMoveName().equals("Transfer Jug Y to Jug X")){
        }
        else{
            System.out.println("Invalid Move name, WJmove");
        }
    }

    /**
     * Attempts to perform this move on a given water jug state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>WaterJugState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new water jug state object is returned that
     * reflects this move.
     * A move cannotp be performed if trying to fill or transfer to an already
     * full jug, or if trying to empty or transfer from an empty jug.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the water jug state on which this move is to be performed
     * @return a new water jug state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public State doMove(State otherState) {
	WaterJugState state = (WaterJugState) otherState;
        if(!validMove(state)){
            return null;            
        }
        int x, y;
        x = state.getXLvl();
        y = state.getYLvl();
        switch(getMoveName()){
            case("Fill Jug X"):
                x = 3;
                break;
            case("Fill Jug Y"):
                y = 4;
                break;
            case("Empty Jug X"):
                x = 0;
                break;
            case("Empty Jug Y"):
                y = 0;
                break;
            case("Transfer Jug X to Jug Y"):
                if(y+x > 4){
                    x = x - (4 - y);
                    y=4;
                    
                }
                else{
                y = y+x;
                x=0;
                }

                break;
            case("Transfer Jug Y to Jug X"):

                if(x+y > 3){
                    y = y -(3-x);
                    x = 3;
                }
                else{
                x = x+y;
                y=0;
                }

                break;
        }
        WaterJugState newState = new WaterJugState(x,y);
        return newState;
        
    }
    
    // Private methods and instance fields should go here
    
    private boolean validMove(WaterJugState aState){
        if(isXFull(aState)){
            if(getMoveName().equals("Fill Jug X") || getMoveName().equals("Transfer Jug Y to Jug X")){
                return false;
            }
        }
        else if(isXEmpty(aState)){
            if(getMoveName().equals("Empty Jug X") || getMoveName().equals("Transfer Jug X to Jug Y")){
                return false;
            }
        }
        else if(isYFull(aState)){
            if(getMoveName().equals("Fill Jug Y") || getMoveName().equals("Transfer Jug X to Jug Y")){
                return false;
            }
        }
        
        else if(isYEmpty(aState)){
            if(getMoveName().equals("Empty Jug Y") || getMoveName().equals("Tranfer Jug Y to Jug X")){
                return false;
            }
        }
        return true;
        
    }
        
    /** Determines if the X jug is full, 
     @param WaterJugState that contains the X Jug in question*/  
    private boolean isXFull(WaterJugState state){
        return(state.getXLvl() == 3);
    }
    /** Determines if the Y jug is full, 
     @param WaterJugState that contains the Y Jug in question*/
    private boolean isYFull(WaterJugState state){
        return(state.getYLvl() == 4);
    }
    
    /**Determines if Jug Y is empty
     *@param WaterJugState that contains the Y Jug in question*/
    private boolean isYEmpty(WaterJugState state){
        return(state.getYLvl() == 0);
    }
    
    /**Determines if Jug X is empty
     *@param WaterJugState that contains the X Jug in question*/
    private boolean isXEmpty(WaterJugState state){
        return(state.getXLvl() == 0);
    }
        
}
