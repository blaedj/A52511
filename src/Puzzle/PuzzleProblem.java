/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import framework.Move;
import framework.Problem;
import java.util.ArrayList;
import Puzzle.PuzzleMove;

/**
 *
 * @author blaed
 */
public class PuzzleProblem extends Problem{
    
    public PuzzleProblem(){
        SQUARE[] a = new SQUARE[10];
        initialize(a);
        PuzzleState state = new PuzzleState("initialState", a);
        setCurrentState(state);
        
        ArrayList<Move> moveList = new ArrayList<>();
        
        Integer i = 1;
        String mvName;
        PuzzleMove newMv; 
        for(i=1; i<9; i++){
            mvName = i.toString() + "Right";
            newMv = new PuzzleMove(mvName);
            moveList.add(newMv);
            mvName = i.toString() + "Left";
            newMv = new PuzzleMove(mvName);
            moveList.add(newMv);
            mvName = i.toString() + "Up";            
            newMv = new PuzzleMove(mvName);
            moveList.add(newMv);
            mvName = i.toString() + "Down";            
            newMv = new PuzzleMove(mvName);
            moveList.add(newMv);
        }
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
        private void initialize(SQUARE a[]){
            a[1] = SQUARE.TWO;
            a[2] = SQUARE.EIGHT;
            a[3] = SQUARE.THREE;
            a[4] = SQUARE.ONE;
            a[5] = SQUARE.SIX;
            a[6] = SQUARE.FOUR;
            a[7] = SQUARE.SEVEN;
            a[8] = SQUARE.BLANK;
            a[9] = SQUARE.FIVE;
        }
        
        @Override
        public boolean success() {
            PuzzleState curState = (PuzzleState) getCurrentState();
            SQUARE[] finalBoard = new SQUARE[10];
            finalBoard[0] = null;
            finalBoard[1] = SQUARE.ONE;
            finalBoard[2] = SQUARE.TWO;
            finalBoard[3] = SQUARE.THREE;
            finalBoard[4] = SQUARE.EIGHT;
            finalBoard[5] = SQUARE.BLANK;
            finalBoard[6] = SQUARE.FOUR;
            finalBoard[7] = SQUARE.SEVEN;
            finalBoard[8] = SQUARE.SIX;
            finalBoard[9] = SQUARE.FIVE;
            PuzzleState finalState = new PuzzleState("Final", finalBoard);
                        
            return curState.equals(finalState);
        }

}
