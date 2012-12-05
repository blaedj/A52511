package Puzzle;

import framework.Canvas;
import framework.State;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 *Provides a graphical rendering of the 8-Puzzle Problem
 * @author Blaed Johnston
 */
public class PuzzleCanvas extends Canvas {
    
    public static void main(String[] args){
        JFrame frame = new JFrame("BridgeCanvas Test");
        
        frame.add(new PuzzleCanvas(new PuzzleState()));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    
    
    public PuzzleCanvas(PuzzleState aState){
        super(aState);
        currentState = (PuzzleState) aState;
        
        double wide = getPreferredWidth();
        double high = getPreferredHeight();
        
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createLineBorder(Color.orange));
        
        setBounds(10,10, (int) wide, (int) high);
        setSize(getPreferredSize());
        
        /**@TODO need to add and create any objects to be drawn*/
        
        quickDraw = currentState.toString();
        JTextArea quickDrawArea = new JTextArea(quickDraw);
        add(quickDrawArea);
        repaint();
        setVisible(true);
        
    }
    
    
    private String simpleStateDepict(PuzzleState aState){
        String stringState = "| "+ aState.getBoard().get(1).toString() +"  "+ aState.getBoard().get(2).toString() +"  "+ aState.getBoard().get(3).toString() +"|\n"
                + "| "+ aState.getBoard().get(4).toString() +" "+ aState.getBoard().get(5).toString() +"   "+ aState.getBoard().get(6).toString() +"|\n"
                + "|_"+ aState.getBoard().get(7).toString() +" _"+ aState.getBoard().get(8).toString() +" _"+ aState.getBoard().get(9).toString() +"|\n";
        return stringState;
    }
    
    private void createVisuals(){
        GridLayout puzzleBoard = new GridLayout();
        puzzleBoard.setColumns(3);
        puzzleBoard.setRows(3);
        setLayout(new GridLayout());
        setSize(getPreferredSize());
        /**@TODO create 9 square, each one represents a tile. fill them with a color and put a value in the center of each. 
         * Then add them to the grid according to what their spot is. rendering will involve changing the value of the 
         * character in the center of each square.
         *TRY TO AVOID CALCULATING THE POSITION AT ALL!!!! USE BUILT INS!!!!
         */
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        //g2.drawString(quickDraw, getWidth()/3 ,getHeight()/3);
    }
    
    @Override
    public void render(){
        quickDraw = currentState.toString();
        add(new JTextArea(quickDraw));
        repaint();
    }
    
    /**
     * Overridden setter for currentState
     * @pre state is an initialized PuzzleState
     * @param state the state to be set as the currentState
     */
    @Override
    public void setState(State state){
        currentState = (PuzzleState) state;
    }
    
    /**
     * @TODO implement paintComponent()
     * @TODO implement render()*/
    private String quickDraw;
    private PuzzleState currentState;
}
