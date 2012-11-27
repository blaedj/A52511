package bridge;

import framework.Move;
import framework.State;

/**
 * This class represents moves in the Bridge Crossing problem.
 * A move object stores its move name and knows how to apply itself
 * to a bridge state to create a new state representing the result
 * of the move.
 * Note that this class extends the abstract class <b>Move</b> and
 * therefore imports <b>framework.Move</b>.
 * This class inherits the <b>getMoveName()</b> method from its parent
 * and thus it should not have an instance field for the move name.
 * Other than that, it can be essentially the same as in the previous
 * assignment.
 * @author your name here
 */
public class BridgeMove extends Move {

    /**
     * Constructs a new bridge move object.
     * Note that the move name is passed to the parent constructor
     * using <b>super</b>.
     * @param moveName the name of this move.
     * It is an error if the name is not one of the following:
     * <ul>
     * <li> "P1 crosses alone" </li>
     * <li> "P2 crosses alone" </li>
     * <li> "P5 crosses alone" </li>
     * <li> "P10 crosses alone" </li>
     * <li> "P1 crosses with P2" </li>
     * <li> "P1 crosses with P5" </li>
     * <li> "P1 crosses with P10" </li>
     * <li> "P2 crosses with P5" </li>
     * <li> "P2 crosses with P10" </li>
     * <li> "P5 crosses with P10" </li>
     * </ul>
     */
    public BridgeMove(String moveName) {
        super(moveName);
	if(!"P1 crosses alone".equals(moveName) &&
	   !"P2 crosses alone".equals(moveName) && !"P5 crosses alone".equals(moveName)
	   &&  !"P10 crosses alone".equals(moveName) && !"P1 crosses with P2".equals(moveName)
	   && !"P1 crosses with P5".equals(moveName)
	   && !"P1 crosses with P10".equals(moveName) && !"P2 crosses with P5".equals(moveName) 
	   && !"P2 crosses with P10".equals(moveName)
	   && !"P5 crosses with P10".equals(moveName))
	    {
                System.out.println("Illegal move name. internal error ");
	    }
        

    }
    
    /**
     * Attempts to perform this move on a given bridge state.
     * Note that this method implements the abstract <b>doMove</b> method declared
     * in the parent.
     * Thus the argument of type <b>State</b> must be cast to type
     * <b>BridgeState</b> before processing.
     * The move to perform is determined by this object's move name.
     * If the move can be performed a new bridge state object is returned that
     * reflects this move.
     * A move cannot be performed if the flashlight is not on the same side
     * as the crossing person(s), or if a pair of persons who are crossing are not
     * on the same side.
     * If the move cannot be performed <b>null</b> is returned.
     * @param otherState the bridge state on which this move is to be performed
     * @return a new bridge state reflecting the move, or <b>null</b> if it
     * cannot be performed
     */
    public State doMove(State otherState) {
        BridgeState state = (BridgeState) otherState;
	Position p1, p2, p5, p10, flashlight;
        int timeElap;
        
        p1 = state.getP1Position();
        p2 = state.getP2Position();
        flashlight = state.getFlashlightPosition();
        p5 = state.getP5Position();
        p10 = state.getP10Position();
        timeElap = state.getTimeSoFar();
        
        switch(getMoveName()){
	case("P1 crosses alone"):
	    if(validator(p1, flashlight))
                {
                    p1 = opposite(p1);
                    timeElap += 1;
                }
	    else return null;
	    break;
	case("P2 crosses alone"):
	    if(validator(p2, flashlight))
                {
                    p2 = opposite(p2);
                    timeElap += 2;
                }
	    else return null;
	    break;
	case("P5 crosses alone"):
	    if(validator(p5, flashlight))
                {
                    p5 = opposite(p5);
                    timeElap += 5;
                }
	    else return null;
	    break;
	case("P10 crosses alone"):
	    if(validator(p10, flashlight))
                {
                    p10 = opposite(p10);
                    timeElap += 10;
                }
	    else return null;
	    break;
	case("P1 crosses with P2"):
	    if(validator(p1, p2, flashlight))
                {
                    p1 = opposite(p1);
                    p2 = opposite(p2);
                    timeElap += 2;
                }
	    else return null;
	    break;
	case("P1 crosses with P5"):
	    if(validator(p1, p5, flashlight))
                {
                    p1 = opposite(p1);
                    p5 = opposite(p5);
                    timeElap += 5;
                }
	    else return null;
	    break;
	case("P1 crosses with P10"):
	    if(validator(p1, p10, flashlight))
                {
                    p1 = opposite(p1);
                    p10 = opposite(p10);
                    timeElap += 10;
                }
	    else return null;
	    break;
	case("P2 crosses with P5"):
	    if(validator(p2, p5, flashlight))
                {
                    p2 = opposite(p2);
                    p5 = opposite(p5);
                    timeElap += 5;
                }
	    else return null;
	    break;
	case("P2 crosses with P10"):
	    if(validator(p2, p10, flashlight))
                {
                    p2 = opposite(p2);
                    p10 = opposite(p10);
                    timeElap += 10;
                }
	    else return null;
	    break;
	case("P5 crosses with P10"):
	    if(validator(p5, p10, flashlight))
                {
                    p5 = opposite(p5);
                    p10 = opposite(p10);
                    timeElap += 10;
                }
	    else return null;
	    break;
        }//end of switch
        flashlight = opposite(flashlight);
        BridgeState newState = new BridgeState(p1, p2, flashlight, p5, p10, timeElap);
        return newState;  
    }

    
 
    private boolean validator(Position a, Position b, Position f)
    {
	if(a == b && b==f){
	    return true;
	}
	else{
	    return false;
	}
    }
    
    /** same as above, but overloaded to work with 2 parameters*/
    private boolean validator(Position a, Position f)
    {
	if(a == f)
	    return true;
	else
	    return false;
    }
    /**Moves the position object of a bridge state to the opposite side of the bridge*/
    private Position opposite(Position pn){
	if(pn == Position.EAST){
	    pn = Position.WEST;
	}
	else{
	    pn = Position.EAST;
	}
	return pn;
    }
}
