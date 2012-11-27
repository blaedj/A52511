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
    public State doMove(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    /** @TODO need to decide how to implement move, what private members etc*/
}
