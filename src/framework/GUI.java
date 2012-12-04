package framework;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;


/**
 * A class that creates GUI components for solving search problems.
 * @author Blaed Johnstonn
 */
public class GUI extends JComponent {
    private final Canvas canvas;
    
    
    public GUI(Problem problem, Canvas canvas) {
        this.aProblem = problem;
        this.canvas = canvas;
        initState = problem.getCurrentState();
        initStateString = initState.toString();
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        initialization();
        this.canvas.repaint();
        createPanel();
    }
    
    // private methods and instance fields go here
    private void createPanel(){
        pane = new JPanel(new BorderLayout(15, 15));

        JComponent curState = canvas;

        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                resetProblem();
            }
        });
        
        pane.add(curState, BorderLayout.WEST);
        pane.add(createIntro(intro), BorderLayout.NORTH);
        pane.add(createMoves(), BorderLayout.EAST);
        pane.add(resetButton, BorderLayout.SOUTH);
        pane.setVisible(true);
        
        this.add(pane);
        
   }
    
    private JComponent createIntro(String s){
        JTextArea introField = new JTextArea(s);
        introField.setEditable(false);
        introField.setVisible(true);
        introField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        return introField;
    }
    
    
    //Deprecated, use canvas instead
    private JTextArea createState(String a){
        JTextArea stateRep = new JTextArea(a);
        stateRep.setEditable(false);
        stateRep.setVisible(true);
        stateRep.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        return stateRep;
    }
    
    private JComponent createMoves(){
        int rowNum = aProblem.getMoves().size();
        ArrayList<JButton> buttonList = new ArrayList<>();
        
        JPanel movesPanel = new JPanel(new GridLayout(rowNum, 1, 5, 3));
        for(final Move move : aProblem.getMoves() ){
            final JButton but = new JButton(move.getMoveName());
            but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event){
                    
                    if(move.doMove(aProblem.getCurrentState()) == null){
                        JOptionPane.showMessageDialog(null, "Invalid Move");
                    }
                    else{
                        
                        State newState = move.doMove(aProblem.getCurrentState());
                        canvas.setState(newState);
                        aProblem.setCurrentState(newState);
                        redraw();
                        if(aProblem.success()){
                            JOptionPane.showMessageDialog(null, "Congratulations! You have solved the problem!");
                        }
                    }
                }
            });
            buttonList.add(but);
        }
        for(JButton button : buttonList){
            movesPanel.add(button);
        }
        movesPanel.setVisible(true);
        return movesPanel;
    }
    
    private void initialization(){
        intro = aProblem.getIntroduction();
        currentState = aProblem.getCurrentState().toString();
    }
    
    private void resetProblem(){
        aProblem.setCurrentState(initState);
        canvas.setState(initState);
        redraw();
    }
    
    private void redraw(){
        this.remove(pane);
        canvas.render();
        createPanel();
    }
    
    
    
    private JPanel pane;
    final private State initState;
    final private String initStateString;
    final private Problem aProblem;
    private String intro;
    private String currentState;
}