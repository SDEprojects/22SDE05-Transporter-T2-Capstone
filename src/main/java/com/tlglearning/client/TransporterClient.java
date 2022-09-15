package com.tlglearning.client;

import com.tlglearning.util.InputHandling;
import com.tlglearning.util.TitleScreen;

import java.io.IOException;

public class TransporterClient {

    public static void main(String[] args) throws IOException {
        //shows the title screen and introduction
        TitleScreen start = new TitleScreen();
        start.titleScreen();
        start.intro();

        //initializes input handling and calls the gameStart method to start new game or quit
        InputHandling gameStart = new InputHandling();
        gameStart.gameStart();
    }
}
