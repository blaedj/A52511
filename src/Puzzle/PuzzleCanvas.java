package Puzzle;

import framework.Canvas;
import framework.State;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
/**
 *Provides a graphical rendering of the 8-Puzzle Problem
 * Warning: severely violates DRY!!
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
        
        
        makeObjects();
        repaint();
        setVisible(true);
        
    }
    
    //deprecated, early testing method.
    private String simpleStateDepict(PuzzleState aState){
        String stringState = "| "+ aState.getBoard().get(1).toString() +"  "+ aState.getBoard().get(2).toString() +"  "+ aState.getBoard().get(3).toString() +"|\n"
                + "| "+ aState.getBoard().get(4).toString() +" "+ aState.getBoard().get(5).toString() +"   "+ aState.getBoard().get(6).toString() +"|\n"
                + "|_"+ aState.getBoard().get(7).toString() +" _"+ aState.getBoard().get(8).toString() +" _"+ aState.getBoard().get(9).toString() +"|\n";
        return stringState;
    }
    
    @Override
    protected void makeObjects(){
       
        /**@TODO create 9 square, each one represents a tile. fill them with a color and put a value in the center of each.
         * Then add them to the grid according to what their spot is. rendering will involve changing the value of the
         * character in the center of each square.
         *TRY TO AVOID CALCULATING THE POSITION AT ALL!!!! USE BUILT INS!!!!
         */
                
        double wide = getWidth();
        double high = getHeight();
        
        double rectangleWidth = wide/3;
        double rectangleHeight = high/3;
        
        tile1 = new Rectangle2D.Double(0, 0, rectangleWidth, rectangleHeight);
        tile2 = new Rectangle2D.Double((wide/3), 0, rectangleWidth, rectangleHeight);
        tile3 = new Rectangle2D.Double(2*(wide/3), 0, rectangleWidth, rectangleHeight);
        
        tile4 = new Rectangle2D.Double(0, high/3, rectangleWidth, rectangleHeight);
        tile5 = new Rectangle2D.Double((wide/3), high/3, rectangleWidth, rectangleHeight);
        tile6 = new Rectangle2D.Double(2*(wide/3), high/3, rectangleWidth, rectangleHeight);
        
        tile7 = new Rectangle2D.Double(0, 2*(high/3), rectangleWidth, rectangleHeight);
        tile8 = new Rectangle2D.Double((wide/3), 2*(high/3), rectangleWidth, rectangleHeight);
        tile9 = new Rectangle2D.Double(2*(wide/3), 2*(high/3), rectangleWidth, rectangleHeight);
        
        setStrings();
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);

        g2.setStroke(new BasicStroke(5));
                
        g2.draw(tile1);
        g2.draw(tile2);
        g2.draw(tile3);
        g2.draw(tile4);
        g2.draw(tile5);
        g2.draw(tile6);
        g2.draw(tile7);
        g2.draw(tile8);
        g2.draw(tile9);
        
	Font font = new Font("Sans", Font.BOLD , 18);
        g2.setColor(Color.RED);
        g2.setFont(font);
        g2.setStroke(new BasicStroke(2));
        
        g2.drawString(tileVal1, (int) tile1.getCenterX(), (int)tile1.getCenterY());
        g2.drawString(tileVal2, (int) tile2.getCenterX(), (int)tile2.getCenterY());
        g2.drawString(tileVal3, (int) tile3.getCenterX(), (int)tile3.getCenterY());
        g2.drawString(tileVal4, (int) tile4.getCenterX(), (int)tile4.getCenterY());
        g2.drawString(tileVal5, (int) tile5.getCenterX(), (int)tile5.getCenterY());
        g2.drawString(tileVal6, (int) tile6.getCenterX(), (int)tile6.getCenterY());
        g2.drawString(tileVal7, (int) tile7.getCenterX(), (int)tile7.getCenterY());
        g2.drawString(tileVal8, (int) tile8.getCenterX(), (int)tile8.getCenterY());
        g2.drawString(tileVal9, (int) tile9.getCenterX(), (int)tile9.getCenterY());
        
    }
    
    @Override
    public void render(){
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
        makeObjects();
    }
    
    private void setStrings(){
        tileVal1 = currentState.getBoard().get(1).toString();
        tileVal2 = currentState.getBoard().get(2).toString();
        tileVal3 = currentState.getBoard().get(3).toString();
        tileVal4 = currentState.getBoard().get(4).toString();
        tileVal5 = currentState.getBoard().get(5).toString();
        tileVal6 = currentState.getBoard().get(6).toString();
        tileVal7 = currentState.getBoard().get(7).toString();
        tileVal8 = currentState.getBoard().get(8).toString();
        System.out.println("Tile value 8 is:"+tileVal8+".");
        tileVal9 = currentState.getBoard().get(9).toString();
    }
    
    /**
     * @TODO implement paintComponent()
     * @TODO implement render()*/
    private String quickDraw;
    private PuzzleState currentState;
    private Rectangle2D.Double tile1;
    private Rectangle2D.Double tile2;
    private Rectangle2D.Double tile3;
    private Rectangle2D.Double tile4;
    private Rectangle2D.Double tile5;
    private Rectangle2D.Double tile6;
    private Rectangle2D.Double tile7;
    private Rectangle2D.Double tile8;
    private Rectangle2D.Double tile9;
    private String tileVal1;
    private String tileVal2;
    private String tileVal3;
    private String tileVal4;
    private String tileVal5;
    private String tileVal6;
    private String tileVal7;
    private String tileVal8;
    private String tileVal9;

}