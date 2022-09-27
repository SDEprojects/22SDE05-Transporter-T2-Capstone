package com.tlglearning.model;

import javax.imageio.ImageIO;


    public class Intro extends SuperObject {
        public Intro() {
            name = "Intro";

            try {
                image = ImageIO.read(getClass().getResourceAsStream("/intro_bg.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

