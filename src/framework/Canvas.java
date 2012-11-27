 
package framework;

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
    /**Creates a new canvas object
     * stores the first state object displayed
     * @param state state to be stored/displayed
     */
    public Canvas(State state){
        this.state = state;
        prevState = state;
        setVisible(true);
        

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
