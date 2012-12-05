package Puzzle;

import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import Puzzle.PuzzleMove;

/**
 *
 * @author Blaed Johnston
 */
public class PuzzleProblem extends Problem{

/**
 * Constructs a new PuzzleProblem
 * @param state the initial state of the PuzzleProblem
 */
    public PuzzleProblem(PuzzleState state){
        curPuzzleState = (PuzzleState) state;
        super.setCurrentState(curPuzzleState);
        ArrayList<Move> moveList = new ArrayList<>();

	moveList.add(new PuzzleMove("Tile1"));
	moveList.add(new PuzzleMove("Tile2"));
	moveList.add(new PuzzleMove("Tile3"));
	moveList.add(new PuzzleMove("Tile4"));
	moveList.add(new PuzzleMove("Tile5"));
	moveList.add(new PuzzleMove("Tile6"));
	moveList.add(new PuzzleMove("Tile7"));
	moveList.add(new PuzzleMove("Tile8"));
	
        setMoves(moveList);
        String introString = "Welcome to the 8-puzzle problem. Any tile can be moved to an adjacent blank tile.\n"
	    + "Try to move the tiles into the final state shown below.\n"
	    + "| 1  2  3|\n"
	    + "| 8     4|\n"
	    + "|_7 _6 _5|\n";
        setIntroduction(introString);
    }
                
    @Override
        public boolean success() {

        PuzzleState finalState = new PuzzleState(1,2,3,8,0,4,7,6,5);
        //PuzzleState curState = (PuzzleState) getCurrentState();
	boolean retVal = curPuzzleState.equals(finalState);
        return retVal;
    }
    private PuzzleState curPuzzleState;
}
