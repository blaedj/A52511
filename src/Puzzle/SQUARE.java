/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Puzzle;

/**
 *
 * @author blaed
 */
public enum SQUARE {
    
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, BLANK, EMPTY;
    
    
    /** 
     * Takes in an integer and returns the corresponding SQUARE value.
     * @param x an integer from 1-8, inclusive,
     * @return SQUARE value corresponding to the int, null if x is not in the acceptable range.
     */
    public static SQUARE fromInt(int x){
        switch(x){
            case(1):
                return ONE;
            case(2):
                return TWO;
            case(3):
                return THREE;
            case(4):
                return FOUR;
            case(5):
                return FIVE;
            case(6):
                return SIX;
            case(7):
                return SEVEN;
            case(8):
                return EIGHT;
            default:
                return null;
        }
    }
    
    public String toString(){
        switch(this){
            case ONE:
                return "1";
            case TWO:
                return "2";
            case THREE:
                return "3";
            case FOUR:
                return "4";
            case FIVE:
                return "5";
            case SIX:
                return "6";
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case BLANK:
                return " ";
            default:
                return null;
        }
    }
}
