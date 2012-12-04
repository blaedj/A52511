package Puzzle;

import framework.GUI;
import javax.swing.JFrame;

/**
 * A class to test your GUI class on the bridge crossing problem.
 * @author tcolburn
 */
public class PuzzleGUI extends JFrame {
    
    public PuzzleGUI() {
        add(new GUI(new PuzzleProblem(new PuzzleState(2,8,3,1,6,4,7,0,5)), new PuzzleCanvas(new PuzzleState())));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * This method launches the gui.
     * @param args ignored
     */
    public static void main(String[] args) {
        new PuzzleGUI();
    }
    
}