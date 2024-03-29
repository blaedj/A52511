package waterjug;

import framework.GUI;
import javax.swing.JFrame;

/**
 * A class to test your GUI class on the water jug problem.
 * @author tcolburn
 */
public class WaterJugGUI extends JFrame {
    
    public WaterJugGUI() {
        add(new GUI(new WaterJugProblem(),new WaterJugCanvas(new WaterJugState(0, 0))));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * This method launches the GUI.
     * @param args ignored
     */
    public static void main(String[] args) {
        new WaterJugGUI();
    }
    
}