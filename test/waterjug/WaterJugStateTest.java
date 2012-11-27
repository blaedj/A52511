package waterjug;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test the WaterJugState class
 * @author Blaed Johnston
 */
public class WaterJugStateTest {
    
    private String state1String = "       |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "|   |  |   |\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
                                 
    
    private String state2String = "       |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "|***|  |***|\n" +
                                  "+---+  +---+\n" +
                                  "  X      Y  \n";
    
    // You may want to add more instance fields for testing

    /**
     * This method tests the accessors (getters) for <b>WaterJugState</b> objects.
     */
    @Test
    public void testAccessors() {
        WaterJugState newState = new WaterJugState(0, 4);
        assertTrue(newState.getXLvl() == 0);
        assertFalse(newState.getXLvl() == 3);
        assertFalse(newState.getXLvl() == 4);
        
        assertFalse(newState.getYLvl()== 3);
        assertTrue(newState.getYLvl() == 4);
    }

    /**
     * This method tests the <b>equals</b> method for <b>WaterJugState</b> objects.
     */
    @Test
    public void testEquals() {
        WaterJugState testerState = new WaterJugState(1, 3);
        assertTrue(testerState.equals(new WaterJugState(1,3)));
        assertFalse(testerState.equals(new WaterJugState(0,2)));
    }

    /**
     * This method tests the <b>toString</b> method for <b>WaterJugState</b> objects.
     * Look at the definitions of <b>state1String</b> and <b>state2String</b> to see
     * how <b>toString</b> should format a state's string representation.
     */
    @Test
    public void testToString() {
        WaterJugState aState = new WaterJugState(3,4);
        //System.out.print(aState.toString());
        assertTrue(state2String.equals(aState.toString()));
        

    }
}
