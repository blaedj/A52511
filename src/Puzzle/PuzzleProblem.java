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
    
    public PuzzleProblem(){

	ArrayList<SQUARE> a = initialize();
        PuzzleState state = new PuzzleState("initialState", a);
        setCurrentState(state);
        
        ArrayList<Move> moveList = new ArrayList<>();

	moveList.add(new PuzzleMove("Tile1"));
	moveList.add(new PuzzleMove("Tile2"));
	moveList.add(new PuzzleMove("Tile3"));
	moveList.add(new PuzzleMove("Tile4"));
	moveList.add(new PuzzleMove("Tile5"));
	moveList.add(new PuzzleMove("Tile6"));
	moveList.add(new PuzzleMove("Tile7"));
	moveList.add(new PuzzleMove("Tile8"));
	
        System.out.println(moveList.size());
        setMoves(moveList);
        String introString = "Welcome to the 8-puzzle problem. Any tile can be moved to an adjacent blank tile./n"
	    + "Try to move the tiles into the final state shown below.\n"
	    + "| 1  2  3|\n"
	    + "| 8     4|\n"
	    + "|_7 _6 _5|\n";
        setIntroduction(introString);
    
    }
        
        
    /**
     * Initializes the state of the board to match the required initial state
     * May need to be changed for various initial states.
     */
    private ArrayList<SQUARE> initialize(){
	ArrayList<SQUARE> a = new ArrayList<>();
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
        
    @Override
        public boolean success() {
	PuzzleState curState = (PuzzleState) getCurrentState();
	
        ArrayList<SQUARE> finalBoard = new ArrayList<>();
	finalBoard.add(SQUARE.EMPTY);
	finalBoard.add(SQUARE.ONE);
	finalBoard.add(SQUARE.TWO);
	finalBoard.add(SQUARE.THREE);
	finalBoard.add(SQUARE.EIGHT);
	finalBoard.add(SQUARE.BLANK);
	finalBoard.add(SQUARE.FOUR);
	finalBoard.add(SQUARE.SEVEN);
	finalBoard.add(SQUARE.SIX);
	finalBoard.add(SQUARE.FIVE);
	PuzzleState finalState = new PuzzleState("Final", finalBoard);
                        
	return curState.equals(finalState);
    }

}
