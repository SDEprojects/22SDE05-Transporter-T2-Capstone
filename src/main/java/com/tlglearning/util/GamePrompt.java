package com.tlglearning.util;

import com.tlglearning.communication.CommunicationManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import static com.tlglearning.util.JacksonParser.parseToMap;

public class GamePrompt {
    private CommunicationManager coms = CommunicationManager.getInstance();
    private InputStream gameJson = InputHandling.class.getClassLoader().getResourceAsStream("gameprompt.json");

    private HashMap<String, String> gameInput;
    {
        try {
            gameInput = parseToMap(gameJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // CTOR
    public GamePrompt() {

    }
    //get text from gameInput and color it White
    public String runPrompt(String key) {
        String result = new String( "\n" +
                //PrettyText.RESET.getColor() +
                gameInput.get(key));

        System.out.println(result);
        coms.communicateToApp(result);
        return result;

    }
    //get text from gameInput and color it Cyan
    public void runPromptCyan(String key) {
        System.out.println("\n" +
                PrettyText.CYAN.getColor() +
                gameInput.get(key) +
                PrettyText.RESET.getColor());

                coms.communicateToApp(gameInput.get(key));

    }
    //get text from gameInput and color it Red
    public void runPromptRed(String key) {
        System.out.println("\n" +
                PrettyText.RED.getColor() +
                gameInput.get(key) +
                PrettyText.RESET.getColor());
        coms.communicateToApp(gameInput.get(key));
    }

    public void runPromptWithLocation(String key, String nextLocation) {
        System.out.println("\n" +
                PrettyText.RESET.getColor() +
                gameInput.get(key) +
                nextLocation);
        coms.communicateToApp(gameInput.get(key) + nextLocation);
    }

    public String getMap(String key){
        coms.communicateToApp(gameInput.get(key));
        return "\n" +
                PrettyText.RESET.getColor() +
                gameInput.get(key);
    }


}

