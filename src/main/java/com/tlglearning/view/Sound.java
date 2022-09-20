package com.tlglearning.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[13];

    public Sound(){

        /* songs */
        soundURL[0] = getClass().getResource("/sounds/musictheme.wav");
        soundURL[1] = getClass().getResource("/sounds/werewolfsong.wav");

        /* success sounds */
        soundURL[2] = getClass().getResource("/sounds/coin.wav");
        soundURL[3] = getClass().getResource("/sounds/powerup.wav");
        soundURL[4] = getClass().getResource("/sounds/unlock.wav");
        soundURL[5] = getClass().getResource("/sounds/fanfare.wav");
        soundURL[7] = getClass().getResource("/sounds/levelup.wav");

        soundURL[6] = getClass().getResource("/sounds/doorlocked.wav");
        soundURL[8] = getClass().getResource("/sounds/cursor.wav");
    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);


        }
        catch (Exception e){
        }


    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
//        FloatControl gainControl =
//                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//        gainControl.setValue(-45.0f);
        clip.start();

    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();

    }

    public void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
