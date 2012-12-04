package framework.test;

import Puzzle.PuzzleCanvas;
import Puzzle.PuzzleProblem;
import Puzzle.PuzzleState;
import bridge.BridgeCanvas;
import bridge.BridgeProblem;
import bridge.BridgeState;
import bridge.Position;
import framework.GUI;
import framework.ProblemPane;
import javax.swing.JFrame;
import waterjug.WaterJugCanvas;
import waterjug.WaterJugProblem;
import waterjug.WaterJugState;

/**
 * A class to display the bridge crossing and water jug problems in a tabbed pane
 * within an application frame.
 * @author tcolburn
 */
public class TestFrame extends JFrame {
    
    public TestFrame() {
        super("Testing Bridge, Water Jug, and 8-Puzzle Problems");
        ProblemPane problemPane = new ProblemPane();
        problemPane.add("Bridge", new GUI(new BridgeProblem(),new BridgeCanvas(new BridgeState(Position.WEST, 
                                                   Position.WEST, 
                                                   Position.WEST, 
                                                   Position.WEST, 
                                                   Position.WEST,
                                                   0))));
        problemPane.add("Water Jug", new GUI(new WaterJugProblem(), new WaterJugCanvas(new WaterJugState(0, 0))));

        problemPane.add("8-Puzzle", new GUI(new PuzzleProblem(new PuzzleState(2,8,3,1,6,4,7,0,5)), new PuzzleCanvas(new PuzzleState())));
        
        add(problemPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new TestFrame();
    }
    
}