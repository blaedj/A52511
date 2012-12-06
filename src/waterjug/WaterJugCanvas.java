/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package waterjug;

import framework.Canvas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Blaed Johnston
 */
public class WaterJugCanvas extends Canvas {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("WaterJugCanvas Test");
//        frame.add(new WaterJugCanvas(new WaterJugState(0, 0)));
//        
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
    
    private final int high;
    private final int wide;
    private GeneralPath jugX;
    private GeneralPath jugY;
    private Rectangle2D.Double watX;
    private Rectangle2D.Double watY;
    
    public WaterJugCanvas(WaterJugState wState){
        super(wState, new WaterJugState());
        
        wide = 600;
        high = 400;
        
        setLayout(new FlowLayout());
        setSize(getPreferredSize());
        makeJugs();
        makeWater();
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g2.draw(jugX);
        g2.draw(jugY);
        g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        g2.drawString(getXs(),(int) (.2*wide), (int) (.75*high));
        g2.drawString(getYs(),(int) (.6*wide), (int) (.75*high));
        g2.setColor(Color.blue);
        g2.fill(watX);
        g2.fill(watY);
    }
    
    @Override
    protected void makeObjects(){
        makeJugs();
        makeWater();
    }
    
    private void makeWater(){
        watX = new Rectangle2D.Double();
        watY = new Rectangle2D.Double();
        
        WaterJugState wState = (WaterJugState) getState();
        if(wState.getXLvl() == 0){}
        else if(wState.getXLvl() == 1){
            watX = new Rectangle2D.Double(.15*wide, .6*high,.2*wide, .1*high);
        }
        else if(wState.getXLvl() == 2){
            watX = new Rectangle2D.Double(.15*wide, .5*high,.2*wide, .2*high);
        }
        else if(wState.getXLvl() == 3){
            watX = new Rectangle2D.Double(.15*wide, .4*high, .2*wide, .3*high);
        }
        
        if(wState.getYLvl() == 0){}
        else if(wState.getYLvl() == 1){
            watY = new Rectangle2D.Double(.55*wide, .6*high,.2*wide, .1*high);
        }
        else if(wState.getYLvl() == 2){
            watY = new Rectangle2D.Double(.55*wide, .5*high,.2*wide, .2*high);
        }
        else if(wState.getYLvl() == 3){
            watY = new Rectangle2D.Double(.55*wide, .4*high, .2*wide, .3*high);
        }
        else if(wState.getYLvl() == 4){
            watY = new Rectangle2D.Double(.55*wide, .3*high, .2*wide, .4*high);
        }
    }
    
    @Override
    public void render(){
        repaint();
    }//end render()
    
    private void translateX(double y, double h){
        double watXy = watX.y + y;
        double watXheight = watX.height + h;
        
        watX = new Rectangle2D.Double(.15*wide, watXy, watXheight, .1*high);
    }
    
    /**Utility function to determine what the height and y-values of the watX rectangle should be.
     * @param xLvl the water level that determines the size of the watX
     * @return dim the dimension containing the width and height values that correspond to the
     *  y and h values of setRect(x, <b>y</b>, w, <b>h</b>);
     */
    private Dimension getXBounds(int xLvl){
        Dimension dim = new Dimension();
        if(xLvl == 1){
            dim.setSize(.6*high, .1*high );
        }
        else if(xLvl == 2){
            dim.setSize(.5*high, .2*high);
        }
        else if(xLvl == 3){
            dim.setSize(.4*high, .3*high);
        }
        return dim;
    }
    
    
    private void makeJugs(){
        jugX = new GeneralPath();
        jugY = new GeneralPath();
        
        jugX.moveTo(.15*wide, .4*high);
        jugX.lineTo(.15*wide, .7*high);
        jugX.lineTo(.35*wide, .7*high);
        jugX.lineTo(.35*wide, .4*high);
        
        jugY.moveTo(.55*wide, .3*high);
        jugY.lineTo(.55*wide, .7*high);
        jugY.lineTo(.75*wide, .7*high);
        jugY.lineTo(.75*wide, .3*high);
        
    }
    
    private String getYs(){
        WaterJugState wst = (WaterJugState) getState();
        Integer temp = wst.getYLvl();
        return "Y(" + temp.toString() + ")";
    }
    
    
    
    private String getXs(){
        WaterJugState wst = (WaterJugState) getState();
        Integer temp = wst.getXLvl();
        return "X(" + temp.toString() + ")";
    }
    
    
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(wide, high);
    }
    
    
    

}
