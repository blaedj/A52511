package framework;

import graph.DequeAdder;
import graph.Vertex;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;
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
        initState = canvas.getInitState();
        initStateString = initState.toString();
        moveCount = 0;
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        initialization();
        this.canvas.repaint();
        createPanel();
    }
    
    // private methods and instance fields go here
    private void createPanel(){
        pane = new JPanel(new BorderLayout(15, 15));
        //        JComponent curState = canvas;
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                resetProblem();
            }
        });
        
        JPanel searchTypes = new JPanel();
        JRadioButton breadth = new JRadioButton("Breadth First");
        JRadioButton depth = new JRadioButton("Depth First");
        final ButtonGroup searchButtons = new ButtonGroup();
        breadth.setActionCommand("BreadthFirst");
        depth.setActionCommand("DepthFirst");
        searchButtons.add(depth);
        searchButtons.add(breadth);
        searchTypes.setBorder(BorderFactory.createTitledBorder("Search Types"));
        /**
         * @TODO Finish creating the UI for solving the problem, include step by step and all at once
         */
        
        
        JButton solveButton = new JButton("SOLVE");
        
        solveButton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                DequeAdder tailAdder = new DequeAdder(){
                    @Override
                    public void add(Vertex vertex, Deque<Vertex> deque) {
                        deque.addLast(vertex);
                    }
                };
                 DequeAdder headAdder = new DequeAdder() {
                     @Override
                    public void add(Vertex vertex, Deque<Vertex> deque) {
                        deque.addFirst(vertex);
                    }
                };
                 if(searchButtons.getSelection().getActionCommand().equals("BreadthFirst")){
                    solution = aProblem.search((Vertex)aProblem.getCurrentState(), tailAdder);
                }
                 else if(searchButtons.getSelection().getActionCommand().equals("DepthFirst")){
                    solution = aProblem.search((Vertex)aProblem.getCurrentState(), headAdder);
                }
            }
         });
        
        pane.add(canvas, BorderLayout.WEST);
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
    
    
    /**
     * @deprecated Use canvas instead
     * @param a the string representation of the state
     * @return JTextarea containing a
     */
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
                    State newState = move.doMove(aProblem.getCurrentState());
                    
                    if(newState == null){
                        JOptionPane.showMessageDialog(null, "Invalid Move");
                    }
                    else{
                        canvas.setState(newState);
                        aProblem.setCurrentState(newState);
                        redraw();
                        moveCount++;
                        if(aProblem.success()){
                            JOptionPane.showMessageDialog(null, "Congratulations! You have solved the problem in "+moveCount+" moves!");
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
        //currentState = aProblem.getCurrentState().toString();
    }
    
    private void resetProblem(){
        aProblem.resetToInit();
        canvas.setState(initState);
        redraw();
    }
    
    private void redraw(){
        this.remove(pane);
        canvas.render();
        createPanel();
    }
    
    
    private Vertex solution;
    private JPanel pane;
    final private State initState;
    final private String initStateString;
    private Problem aProblem;
    private String intro;
    private String currentState;
    private int moveCount;
}
