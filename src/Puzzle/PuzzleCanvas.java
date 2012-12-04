/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

import framework.Canvas;
import framework.State;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
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
        double wide = getPreferredWidth();
        double high = getPreferredHeight();
        
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createLineBorder(Color.orange));
        
        setBounds(10,10, (int) wide, (int) high);
        setSize(getPreferredSize());

        /**@TODO need to add and create any objects to be drawn*/

        quickDraw =
	    "| "+ aState.getBoard().get(1).toString() +"  "+ aState.getBoard().get(2).toString() +"  "+ aState.getBoard().get(3).toString() +"|\n"
	    + "| "+ aState.getBoard().get(4).toString() +" "+ aState.getBoard().get(5).toString() +"   "+ aState.getBoard().get(6).toString() +"|\n"
	    + "|_"+ aState.getBoard().get(7).toString() +" _"+ aState.getBoard().get(8).toString() +" _"+ aState.getBoard().get(9).toString() +"|\n";
        JTextArea quickDrawArea = new JTextArea(quickDraw);
        add(quickDrawArea);
        repaint();
        setVisible(true);
        
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        
        //g2.drawString(quickDraw, getWidth()/3 ,getHeight()/3);
    }
    
    public void render(){
        repaint();
    }
    
    
    /**
     * @TODO implement paintComponent()
     * @TODO implement render()*/
    private String quickDraw;

}
