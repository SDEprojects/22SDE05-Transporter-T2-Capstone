package com.tlglearning.communication;


import com.tlglearning.app.GameFrame;

public class CommunicationManager {
    private static CommunicationManager instance;
    private GameFrame app;

    private String command = "";
    private boolean ready = false;

    private CommunicationManager(){

    }

    public static CommunicationManager getInstance(){
        if (instance == null){
            instance = new CommunicationManager();
        }

        return instance;
    }

    public void addObserver(GameFrame app){
        this.app = app;
    }

    public void communicateToApp(String txt){
        app.appendToGUI("\n");
        app.appendToGUI(txt);
        app.appendToGUI("\n");

    }

    public void setCommand(String txt){
        command = txt.toLowerCase();
        ready = true;

    }
    public String getCommand(){
        while (!ready){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        ready = false;
        return command;
    }

    public boolean checkCommandReady(){
        return ready;
    }

}
