 
package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Blaed Johnston
 */
public abstract class Canvas extends JComponent{
    private State state;
    private State prevState;
    private final State initState;
    private double high = 300;
    private double wide = 450;
    /**Creates a new canvas object
     * stores the first state object displayed
     * @param state state to be stored/displayed
     * @param initState the default initial state
     */
    public Canvas(State state, State initState){
        this.state = state;
        prevState = state;
        this.initState = initState;
        setVisible(true);
    }

    public double getPreferredHeight(){
    return high;
    }
    
    public double getPreferredWidth(){
    return wide;
    }
    
    public State getState(){
        return state;
    }
    
    public void setState( State aState){
        this.state = aState;
        makeObjects();
    }
    
    public State getPrevState(){
        return prevState;
    }
    
    public void setPrevState(State aState){
        prevState = aState;
    }
    
    public State getInitState(){
        return initState;
    }
    
    @Override
    public Dimension getPreferredSize(){
        return new Dimension((int) wide, (int) high);
    }

    protected void makeObjects(){
        //must be overridden
    }
    
    public void render(){
        //must be overridden
    }
    
    @Override
    protected void paintComponent(Graphics g){
        //must be overridden in subclasses
    }


}
