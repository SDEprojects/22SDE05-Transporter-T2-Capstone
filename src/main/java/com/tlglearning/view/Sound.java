package com.tlglearning.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    static Clip clip;
    static Clip clip1;
    URL soundURL[] = new URL[13];

    static URL soundURLMain[] = new URL[3];

    public boolean isPlaying = false;


    public Sound() {

        /* songs */

        soundURLMain[0] = getClass().getResource("/sounds/musictheme_dropkickmurph.wav");
        soundURLMain[1] = getClass().getResource("/sounds/cornered8bit.wav");
        soundURLMain[2] = getClass().getResource("/sounds/drake8bit.wav");

        /* success sounds */
        soundURL[2] = getClass().getResource("/sounds/coin.wav");
        soundURL[3] = getClass().getResource("/sounds/powerup.wav");
        soundURL[4] = getClass().getResource("/sounds/unlock.wav");
        soundURL[5] = getClass().getResource("/sounds/fanfare.wav");
        soundURL[7] = getClass().getResource("/sounds/levelup.wav");

        soundURL[6] = getClass().getResource("/sounds/doorlocked.wav");
        soundURL[8] = getClass().getResource("/sounds/cursor.wav");
        soundURL[9] = getClass().getResource("/sounds/receivedamage.wav");
        soundURL[10] = getClass().getResource("/sounds/gameover.wav");



    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);


        } catch (Exception e) {
        }


    }

    public void play() {



        clip.setFramePosition(0);
        clip.start();
//        FloatControl gainControl =
//                (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
//        gainControl.setValue(+45.0f);
        clip.start();

    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();


    }

    public void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getVolume() {
        try {
            FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
            return (float) Math.pow(10f, gainControl.getValue() / 20f);
        } catch (Exception e) {
            return 0;
        }
    }
    public void setVolume(float level) {
        if(isPlaying) {
            FloatControl gainControl = (FloatControl) clip1.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(level));
        }

    }
    public void stopMain() {

        if (clip1 != null) {
            clip1.stop();
            clip1.close();
        }
        isPlaying = false;



    }
    public void playMain() {
        if(!isPlaying) {
            isPlaying = true;
            clip1.setFramePosition(0);
            clip1.start();
            clip1.loop(Clip.LOOP_CONTINUOUSLY);
        }



    }
    public void setMainFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURLMain[i]);
            clip1 = AudioSystem.getClip();
            clip1.open(ais);


        } catch (Exception e) {
        }


    }
    public void loopMain() {
        clip1.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
