package com.tlglearning.controller;

import javax.swing.*;

public class MainB {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(false);
        window.setTitle("Transporter");
        GamePanelB gamePanel = new GamePanelB();
        window.add(gamePanel);









        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }



}
