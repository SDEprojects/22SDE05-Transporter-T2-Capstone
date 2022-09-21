package com.tlglearning.app;

import com.tlglearning.communication.CommunicationManager;
import com.tlglearning.util.InputHandling;
import com.tlglearning.util.TitleScreen;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* launch game */
public class AppLauncher {

    public static void main(String[] args) throws IOException {

        CommunicationManager coms = CommunicationManager.getInstance();

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    GameFrame app = new GameFrame();
                    coms.addObserver(app);

                }
            });
        }  catch (InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        TitleScreen start = new TitleScreen();
        start.titleScreen();
        InputHandling gameStart = new InputHandling();
        gameStart.gameStart();

    }




}
