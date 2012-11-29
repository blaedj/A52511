/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import framework.Canvas;
import java.awt.*;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.Timer;
/**
 *
 * @author Blaed Johnston
 */
public class BridgeCanvas extends Canvas{
public static void main(String[] args) {
        JFrame frame = new JFrame("BridgeCanvas Test");
        frame.add(new BridgeCanvas(new BridgeState(Position.WEST, 
                                                   Position.WEST, 
                                                   Position.WEST, 
                                                   Position.WEST, 
                                                   Position.WEST,
                                                   0)));
            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     Creates BridgeCanvas that graphically represents the state
     * @param BridgeState bridgeState the state to be graphically represented
     
     */
    public BridgeCanvas(BridgeState bridgeState) {
        super(bridgeState);//call to superclass constructor
        /** 
         * need to create and store any objects to be 
         * drawn by paintComponent()          
         */
        wide = 600;
        height = 400;
        setLayout(new FlowLayout());
        setBorder(BorderFactory.createLineBorder(Color.orange));
        setBounds(10, 10, (int) wide, (int) height);

        setSize(getPreferredSize());

        makeRiver();
        makeBridge();
        makeBackdrop();
        makePersons();
        
        
        repaint();
        setVisible(true);
    }

    @Override
    protected void makeObjects(){
        makeRiver();
        makeBridge();
        makeBackdrop();
        makePersons();
        
    }
    
    @Override
    public void render(){
        repaint();
    }
    

    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        
        super.paintComponent(g2);
        
        g2.setColor(new Color(31, 128, 6));
        g2.fill(backdrop);
        g2.setColor(Color.blue);
        g2.fill(riv);
        //g2.draw(riv);
        g2.setColor(new Color(120,67,7));
        g2.fill(bridge);
        g2.setColor(Color.red);

        for(Shape sh : pList){
            g2.fill(sh);
        }
        g2.setColor(Color.black);
        g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        g2.drawString(getTimeS(), (int)(.35*wide), (int)(.05*height));

        g2.setColor(Color.yellow);
        g2.fill(f);        
        g2.drawString("P1", (float)(.05*wide), (float)(.2*height));
        g2.drawString("P2", (float)(.05*wide), (float)(.35*height));
        g2.drawString("F", (float)(.05*wide), (float)(.5*height));
        g2.drawString("P5", (float)(.05*wide), (float)(.65*height));
        g2.drawString("P10", (float)(.035*wide), (float)(.8*height));
    }

    private void makePersons(){
        //get current state
        //make shapes for people and flashlight
        double Wxp = .1*wide;
        double Exp = .9*wide;
        
        BridgeState state = (BridgeState) getState();
        
        
        if(state.getP1Position() == Position.WEST){
            p1 = new Ellipse2D.Double(Wxp, .15*height, .08*wide, .08*wide);
            
        }
        else{
            p1 = new Ellipse2D.Double(Exp, .15*height, .08*wide, .08*wide);
        }
        
        if(state.getP2Position() == Position.WEST){
            p2 = new Ellipse2D.Double(Wxp, .3*height, .08*wide, .08*wide);
        }
        else{
            p2 = new Ellipse2D.Double(Exp, .3*height, .08*wide, .08*wide);
        }
        
        if(state.getP5Position() == Position.WEST){
            p5 = new Ellipse2D.Double(Wxp, .6*height, .08*wide, .08*wide);
        }
        else{
            p5 = new Ellipse2D.Double(Exp, .6*height, .08*wide, .08*wide);
        }
        
        if(state.getP10Position() == Position.WEST){
            p10 = new Ellipse2D.Double(Wxp, .75*height, .08*wide, .08*wide);
        }
        else{
            p10 = new Ellipse2D.Double(Exp, .75*height, .08*wide, .08*wide);
        }
        
        if(state.getFlashlightPosition() == Position.WEST){
            f = new Ellipse2D.Double(Wxp, .45*height, .08*wide, .08*wide);
        }
        else{
            f = new Ellipse2D.Double(Exp, .45*height, .08*wide, .08*wide);
        }

        pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p5);
        pList.add(p10);
        
        
}
    
    private void makeBackdrop(){
        backdrop = new Rectangle2D.Double(0,0,wide,height);
        
    }
    
    
    private void makeBridge(){
        bridge = new Rectangle2D.Double(.23*wide, .375*height, .33*wide, .225*height);
    }
    
    private void makeRiver(){
        riv = new GeneralPath.Double();
        riv.moveTo(.3*wide, 0);
        riv.quadTo(.2*wide, .3*height, .3*wide, height);
        riv.lineTo(.6*wide, height);
        riv.quadTo(.4*wide, .3*height, .6*wide, 0);
        riv.closePath();
    }
    
    private String getTimeS(){
        BridgeState bstate = (BridgeState) getState();
        Integer time = bstate.getTimeSoFar();
        
        return time.toString() + " Minutes";
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension((int) wide, (int) height);
    }
    
    /**The people and flashlight */
    private Shape p1, p2, p5, p10;
    private Ellipse2D.Double f;
    private ArrayList<Shape> pList;

    /** The river*/
    private GeneralPath.Double riv;
    /**the Bridge*/
    private Rectangle2D.Double bridge;
    /** The background*/
    private Rectangle2D.Double backdrop;    
    /** Total width of the canvas*/
    private double wide;
    /** Total height of the canvas*/
    private double height;
}
