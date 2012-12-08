package bridge;

import framework.State;
import graph.SimpleVertex;

/**
 * This class represents states of the Bridge Crossing problem.
 * It creates new bridge states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 * Except for the import and the class header, this class can be
 * the same as in the previous assignment.
 * @author your name here
 */
public class BridgeState extends SimpleVertex implements State {

    /**
     * Creates a new bridge state.  
     * Besides storing the positions of the persons and flashlight, a
     * bridge state should also store the time taken to get to this state in
     * integer minutes.
     * @param p1Position position of the person who can cross in 1 minute
     * @param p2Position position of the person who can cross in 2 minutes
     * @param flashlightPosition position of the flashlight
     * @param p5Position position of the person who can cross in 5 minutes
     * @param p10Position  position of the person who can cross in 10 minutes
     * @param timeSoFar time taken so far
     */
    public BridgeState(Position p1Position, 
                       Position p2Position, 
                       Position flashlightPosition, 
                       Position p5Position, 
                       Position p10Position,
                       int timeSoFar) {
        this.P1Position = p1Position;
        this.P2Position = p2Position;
        this.flashlightPosition = flashlightPosition;
        this.P5Position = p5Position;
        this.P10Position = p10Position;
        this.timeSoFar = timeSoFar;

    }
    
    /**
     * Creates a default BridgeState, with everyone on the west and time=0
     */
    public BridgeState(){
        P1Position = Position.WEST;
        P2Position = Position.WEST;
        P5Position = Position.WEST;
        P10Position = Position.WEST;
        flashlightPosition = Position.WEST;
        timeSoFar = 0;
    }
    
    
    
    /**
     * Compares this bridge state with another for equality.
     * Two bridge states are equal if the positions of the persons and 
     * flashlight in one state are matched by their positions in the other.
     * Note that the time taken to cross so far is not taken into account
     * when considering equality.
     * @param other the other bridge state to be compared with this one.
     * @return whether this state is equal to the other state
     */
    public boolean equals(Object another) {
        BridgeState other = (BridgeState) another;
        if(this == other){
            return true;
        }
        if(P1Position != other.getP1Position() || P2Position != other.getP2Position()
                || flashlightPosition != other.getFlashlightPosition()||
                P5Position != other.getP5Position() || P10Position != other.getP10Position()){
            return false;
        }
        else{
            return true;
        }

    }
    
    /**
     * Creates a string representation of this state for display to the user
     * trying to solve the problem.
     * Note that the time so far to cross is part of the string representation.
     * @return the string representation of this state
     */
    public String toString() {
	String P1, P2, f, P5, P10;
        if(getP1Position() == Position.WEST){
            P1 = " P1 |   |";
        }
        else{
            P1 = "    |   | P1";
        }
        
        if(getP2Position() == Position.WEST){
            P2 = " P2 |   |";
        }
        else{
            P2 = "    |   | P2";
        }
        
        
        if(getFlashlightPosition() == Position.WEST){
            f = "  f |===|";
        }
        else{
            f = "    |===| f";
        }
        
        if(getP5Position() == Position.WEST){
            P5 = " P5 |   |";
        }
        else{
            P5 = "    |   | P5";
        }
        
        if(getP10Position() == Position.WEST){
            P10 = "P10 |   |";
        }
        else{
            P10 = "    |   | P10";
        }
        int time = getTimeSoFar();
        String timeSo = String.valueOf(time);
        String n =  P1 + "\n" + P2 + "\n" + f + "\n" + P5 + "\n" + P10 + "\n" + "Time elapsed so far: " + timeSo + " minutes.\n";
       
        return n;
    }

    /**
     * Getter (accessor) for the position of the flashlight in this state.
     * @return the position of the flashlight
     */
    public Position getFlashlightPosition() {
	return flashlightPosition;
    }

    /**
     * Getter (accessor) for the position of person P1 in this state.
     * @return the position of person P1
     */
    public Position getP1Position() {
	return P1Position;
    }

    /**
     * Getter (accessor) for the position of person P2 in this state.
     * @return the position of person P2
     */
    public Position getP2Position() {
	return P2Position;
    }

    /**
     * Getter (accessor) for the position of person P5 in this state.
     * @return the position of person P5
     */
    public Position getP5Position() {
	return P5Position;
    }

    /**
     * Getter (accessor) for the position of person P10 in this state.
     * @return the position of person P10
     */
    public Position getP10Position() {
	return P10Position;
    }

    /**
     * Getter (accessor) for the time taken to get to this state.
     * @return the time taken to get to this state
     */
    public int getTimeSoFar() {
	return timeSoFar;
    }
    
    private Position P1Position;
    private Position P2Position;
    private Position flashlightPosition;
    private Position P5Position;
    private Position P10Position;
    private int timeSoFar;
    
}
