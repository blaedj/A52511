package waterjug;

import framework.State;

/**
 * This class represents states of the Water Jug problem.
 * It creates new water jug states, tests states for equality,
 * and produces string representations of them.
 * Note that this class implements the <b>State</b> interface
 * and therefore imports <b>framework.State</b>.
 */
public class WaterJugState implements State {

    /** */
    
    public WaterJugState(int x, int y) {
        if(x < 0 || x > 3 || y < 0 || y > 4){
            System.out.println("error, WJState");
        }
        else{
            xWaterLvl = x;
            yWaterLvl = y;
        }
    }

    
    /**
       Tests for equality between this state and the argument state.
       Two states are equal if the X jugs have the same amount of water
       and the Y jugs have the same amount of water.
       @param other the state to test against this state
       @return whether the states are equal
    */
    public boolean equals(Object other) {
        WaterJugState anOther = (WaterJugState) other;

        return(this.getYLvl() == anOther.getYLvl() && this.getXLvl() == anOther.getXLvl());
    }

    /**
       Creates a primitive, non-GUI representation of this WaterJugState object.
       @return the string representation of this water jug state
     */
    public String toString() {

        String xlvl1, xlvl2, xlvl3, xlvl4, ylvl1, ylvl2, ylvl3, ylvl4;
        xlvl1 = "       ";
        xlvl2 = "|   |  ";
        xlvl3 = "|   |  ";
        xlvl4 = "|   |  ";
        ylvl1 = "|   |\n";
        ylvl2 = "|   |\n";
        ylvl3 = "|   |\n";
        ylvl4 = "|   |\n";
        String lvlbot = "+---+  +---+\n"
                       +"  X      Y  \n";
        
        switch(getXLvl()){
            case(0):
                break;
            case(1):
                xlvl4 = "|***|  ";
                break;
            case(2):
                xlvl4 = "|***|  ";
                xlvl3 = "|***|  ";
                break;
            case(3):
                xlvl4 = "|***|  ";
                xlvl3 = "|***|  ";
                xlvl2 = "|***|  ";
                break;
                default:
                    break;
        }
        
        switch(getYLvl()){
            case(0):
                break;
            case(1):
                ylvl4 = "|***|\n";
                break;
            case(2):
                ylvl4 = "|***|\n";
                ylvl3 = "|***|\n";
                break;
            case(3):
                ylvl4 = "|***|\n";
                ylvl3 = "|***|\n";
                ylvl2 = "|***|\n";
                break;
            case(4):
                ylvl4 = "|***|\n";
                ylvl3 = "|***|\n";
                ylvl2 = "|***|\n";
                ylvl1 = "|***|\n";
                break;
            default:
                break;
        }
        String theString = xlvl1 + ylvl1 + xlvl2 + ylvl2 + xlvl3 + ylvl3 + xlvl4 + ylvl4 + lvlbot;
        return theString;
    }
    
    private int xWaterLvl;
    private int yWaterLvl;
    
    public int getYLvl(){
        return yWaterLvl;
    }
    
    public int getXLvl(){
        return xWaterLvl;
    }


}
