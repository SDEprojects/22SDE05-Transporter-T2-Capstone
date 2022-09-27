package com.tlglearning.app;

import com.tlglearning.communication.CommunicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;

public class GameFrame extends JFrame {
    private GamePanel panel;
    private JTextArea consoleDisplay;
    private JTextField inputArea;
    private JScrollPane pane;
    public GameFrame(){
        init();
    }

    public void init(){
        setTitle("Trucker Game MVP");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(1200, 700));
        setLocationRelativeTo(null);
        panel = new GamePanel();


        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(110, 600));
        panel.setLayout(new BorderLayout());
        consoleDisplay = new JTextArea(30, 90);
        consoleDisplay.setBackground(Color.GRAY);
        consoleDisplay.setEditable(false);
        consoleDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        pane = new JScrollPane(consoleDisplay);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.getVerticalScrollBar().addAdjustmentListener(e -> e.getAdjustable().setValue(e.getAdjustable().getMaximum()));
        inputArea = new JTextField(50);
        inputArea.setBackground(Color.CYAN);
        inputArea.setForeground(Color.RED);

        panel.add(pane, BorderLayout.NORTH);
        panel.add(inputArea, BorderLayout.SOUTH);
        add(panel);
        setVisible(true);

        CommunicationManager coms = CommunicationManager.getInstance();
        inputArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consoleDisplay.append("\n" + inputArea.getText());
                coms.setCommand(inputArea.getText());
                inputArea.setText("");
            }
        });

    }

    public void appendToGUI(String text){
        consoleDisplay.append(text);
    }


}
