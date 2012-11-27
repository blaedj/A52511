package waterjug;

import java.util.List;
import framework.Problem;
import framework.State;
import framework.Move;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugProblem class.
 * You should use the BridgeProblemTest class as a model.
 * @author your name here
 */
public class WaterJugProblemTest {
    
    // You should use the BridgeProblemTest class as a model for setting up
    // the tests with private instance fields and methods here.
    private Problem problem = new WaterJugProblem();
    private List<Move> moves = problem.getMoves();
    
    private Move findMove(String moveName) {
        for (Move move : moves) {
            if (move.getMoveName().equals(moveName)) {
                return move;
            }
        }
        return null;
    }
    
    /**Initialize the moves*/
    Move m1 = findMove("Fill Jug X");
    Move m2 = findMove("Fill Jug Y");
    Move m3 = findMove("Empty Jug X");
    Move m4 = findMove("Empty Jug Y");
    Move m5 = findMove("Transfer Jug X to Jug Y");
    Move m6 = findMove("Transfer Jug Y to Jug X");
    
    private void tryMove(Move move) {
        State state = problem.getCurrentState();
        State next = move.doMove(state);
        problem.setCurrentState(next);
    }
    
    
    /**
     * Tests to be sure the problem represents all the moves.
     */
    @Test
    public void testMoves() {
        assertTrue(m1 != null);
        assertTrue(m2 != null);
        assertTrue(m3 != null);
        assertTrue(m4 != null);
        assertTrue(m5 != null);
        assertTrue(m6 != null);
    }

    /**
     * Tests the 4-move solution to the water jug problem
     */
    @Test
    public void testSolution1() {
        assertFalse(problem.success());
        tryMove(m1);
        
        assertFalse(problem.success());
        tryMove(m5);
        
        assertFalse(problem.success());
        tryMove(m1);
        
        assertFalse(problem.success());
        tryMove(m5);
        assertTrue(problem.success());
    }

    /**
     * Tests the 6-move solution to the water jug problem
     */
    @Test
    public void testSolution2() {
       assertFalse(problem.success());
        tryMove(m2);
        
        assertFalse(problem.success());
        tryMove(m6);
        
        assertFalse(problem.success());
        tryMove(m3);
        
        assertFalse(problem.success());
        tryMove(m6);
        
        assertFalse(problem.success());
        tryMove(m2);
        
        assertFalse(problem.success());
        tryMove(m6);
        
        assertTrue(problem.success());


    }
    
    /**
     * Tests the problem's introduction string.
     */
    @Test
    public void testIntro() {
        assertTrue(problem.getIntroduction().equals("Welcome to the Water Jug Problem.\n\n"
        + "You are given two empty jugs: jug X holds 3 gallons, jug y holds 4.\n"
                + "Neither has any measuring markers on it. You have a ready supply\n"
                + "of water. You can fill either jug, empty either jug on the ground,\n"
                + "or pour all or some of either jug into the other. The goal is to \n"
                + "get exactly 2 gallons into either jug.\n\n"
                + "Here is your initial state:\n"));
    }
    
}
