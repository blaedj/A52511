/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import framework.Canvas;
import framework.State;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
/**
 *
 * @author Blaed Johnston
 */
public class PuzzleCanvas extends Canvas {
    
    public static void main(String[] args){
        JFrame frame = new JFrame("BridgeCanvas Test");

        frame.add(new PuzzleCanvas(new PuzzleState("initial")));
            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    public PuzzleCanvas(PuzzleState aState){
        super(aState);
        /**@TODO need to add and create any objects to be drawn*/
        String quickDraw =
                  "| 1  2  3|\n"
                + "| 8     4|\n"
                + "|_7 _6 _5|\n"
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        
        
    }
    
    public void render(){
        repaint();
    }
    
    
    /**
     * @TODO implement paintComponent()
     * @TODO implement render()*/

}
