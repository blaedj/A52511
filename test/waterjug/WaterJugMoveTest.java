package waterjug;

import framework.Move;
import framework.State;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugMove class.
 * @author Blaed Johnston
 */
public class WaterJugMoveTest {
    
    
    private State start = new WaterJugState(0, 0);
    private State end = new WaterJugState(3, 4);
    
    private Move m1 = new WaterJugMove("Fill Jug X");
    private Move m2 = new WaterJugMove("Fill Jug Y");
    private Move m3 = new WaterJugMove("Empty Jug X");
    private Move m4 = new WaterJugMove("Empty Jug Y");
    private Move m5 = new WaterJugMove("Transfer Jug X to Jug Y");
    private Move m6 = new WaterJugMove("Transfer Jug Y to Jug X");

    
    /**
     * Tests filling jug X
     */
    @Test
    public void testFillX() {
        WaterJugState next = (WaterJugState) m1.doMove(start);
        assertTrue(next.equals(new WaterJugState(3,0)));
    }

    /**
     * Tests filling jug Y
     */
    @Test
    public void testFillY() {
        WaterJugState next = (WaterJugState) m2.doMove(start);
        assertTrue(next.equals(new WaterJugState(0,4)));
        
    }
    
    /**
     * Tests emptying jug X
     */
    @Test
    public void testEmptyX() {
        WaterJugState next = (WaterJugState) m3.doMove(end);
        assertTrue(next.equals(new WaterJugState(0,4)));
    }
    
    /**
     * Tests emptying jug Y
     */
    @Test
    public void testEmptyY() {
        WaterJugState next = (WaterJugState) m4.doMove(end);
        assertTrue(next.equals(new WaterJugState(3,0)));

    }

    /**
     * Tests transferring jug X to jug Y
     */
    @Test
    public void testXToY() {
        WaterJugState next = (WaterJugState) m5.doMove(new WaterJugState(3,0));
        assertTrue(next.equals(new WaterJugState(0, 3)));
    }
    
    /**
     * Tests transferring jug Y to jug X
     */
    @Test
    public void testYToX() {
    WaterJugState next = (WaterJugState) m6.doMove(new WaterJugState(0,4));
    assertTrue(next.equals(new WaterJugState(3, 1)));
    }
}
