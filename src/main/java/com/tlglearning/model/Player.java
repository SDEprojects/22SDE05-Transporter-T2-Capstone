package com.tlglearning.model;

import com.tlglearning.controller.*;
import com.tlglearning.model.objects.OBJ_Package;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Player extends EntityB {

    GamePanelB gp;
    KeyHandlerB keyH;
    public static ArrayList<String> neededItems = new ArrayList<>(Arrays.asList("GPS", "Coffee", "Radio", "Soda", "Folder", "Truck Key", "Thermos"));


    // needed - RADIO HAS BLANK SPOT, CAN FIT 2 MORE - FOLDER, TRUCK KEY, KEY
    // already on - gps(needs new image), thermos(new image), radio, vending.
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    boolean vendingFlag = true;
    boolean coffeeFlag = true;
    boolean deskFlag = true;
    boolean npc1Flag = true;
    public static boolean truckFlag;
    public static float gasCount = 100;
    private float gasDeincrement = (float) .055;

    private double playerMoney = 0;

    private double playerTimeMoney;
    DecimalFormat df = new DecimalFormat("#0.00");

    private Set<State> destinations;


    private LinkedList<OBJ_Package> packagesInTrunck;

    EntityB entity = new EntityB();

    //    public static int packageCounter = 0;
    public static int packageDelivered = 0;
    public static int winSetter = 1;
    public ArrayList topScores;
    private int cashSE = 1;


    public Player(GamePanelB gp, KeyHandlerB keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        /* Used to set the player's collision radius, slightly smaller than a tile */
        solidArea = new Rectangle(8, 16, 16, 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultPosition();
        getPlayerImage();

        setDestinations();
//        currentDestination = getNextDestination();
        packagesInTrunck = new LinkedList<>();
    }

    public void setDestinations() {
        destinations = new HashSet<>();
        destinations.add(State.IL);
        destinations.add(State.KY);
        destinations.add(State.OH);
        destinations.add(State.SC);
        destinations.add(State.TN);
        destinations.add(State.AL);
        destinations.add(State.MD);
        destinations.add(State.WV);
        destinations.add(State.GA);
        destinations.add(State.IN);
        destinations.add(State.VA);
        destinations.add(State.NC);
        //destinations.add(State.MS);
    }

    public State getCurrentDestination() {

        return packagesInTrunck.isEmpty() ? State.MS : packagesInTrunck.get(0).getDestination();

    }

    /* Set Players default position */
    public void setDefaultPosition() {
        worldX = gp.tileSize * 5;
        worldY = gp.tileSize * 184;
        speed = 6;
        direction = "down";
    }

    public void getPlayerImage() {

        if (!truckFlag) {
            try {
                up1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_up1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_up2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_down.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_down2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_left1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_left2.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player1/player_right1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player1/player_right2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (truckFlag) {
            try {
                gasCount = 100;
                up1 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_up.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_up1.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_down.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_down1.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_left.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_left1.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_right.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("/player1/truck_right1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }
            /* Check for collision */
            collisionOn = false;
            gp.cChecker.checkTile(this);
            entity.onRoadOn = false;
            gp.cChecker.checkRoad(this);
            if (truckFlag) {
                if (gasCount < 1) {
                    gp.ui.gameLost = true;
                    gp.playSE(22);
                    double playTime = UI.playTime;
                    GameSaver saver1 = null;
                    try {
                        saver1 = GameSaver.getInstance();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    GameRecord record1 = new GameRecord("Trucker", playTime, playerMoney);
                    saver1.addRecord(record1);

                    topScores = saver1.getTopRanks(3);
                }
                if (gasCount < 1) {
                    speed = 5;
                } else if (onRoadOn && gasCount >= 1) {
                    speed = 25;
                } else if (!onRoadOn && gasCount >= 1) {
                    speed = 6;
                }
            }
            // best playable speeds are 26 on road, 7 off road


            /* Check Obj Collision */

            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            /* If collision is off, player can move */
            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        gasCount = gasCount - gasDeincrement;
                        break;
                    case "down":
                        worldY += speed;
                        gasCount = gasCount - gasDeincrement;
                        break;
                    case "left":
                        worldX -= speed;
                        gasCount = gasCount - gasDeincrement;

                        break;
                    case "right":
                        worldX += speed;
                        gasCount = gasCount - gasDeincrement;

                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            spriteNum = 1;
        }


    }

    public void pickUpObject(int i) {

        if (i != 999) {

            if (packageDelivered == winSetter) {
                gp.ui.gameFinished = true;
                gp.playSE(14);
                // also can use 5 for win sound
                double endCash = playerMoney;
                double playTime = UI.playTime;
                GameSaver saver = null;
                try {
                    saver = GameSaver.getInstance();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                GameRecord record = new GameRecord("Trucker", playTime, endCash);
                saver.addRecord(record);

                saver.saveToJSON();
                topScores = saver.getTopRanks(3);


            }

            String objectName = gp.obj[i].name;
            String[] randomStringList = {"YEAH BUDDDDYYY! You found some cash. You get $", "OH YEAHH!! you picked up $", "WHAAAAT??!? You find money while driving. You get $", "LETS GO! You found $", "One man's trash is another man's treasure, or maybe it's just treasure. You picked up $", "Another day another dollar! You found $", "THAT'S WHAT IM TALKING ABOUT! You picked up $"};
            Random rand = new Random();
            int randomIndex = rand.nextInt(randomStringList.length);
            String randomString = randomStringList[randomIndex];
            switch (objectName) {
                case "Radio":
                    gp.playSE(12);
                    neededItems.remove("Radio");
                    npc1Flag = false;
                    gp.ui.showMessage("The truck radio is broken, fortunately you find a spare! Start your playlist with the space bar!");
                    gp.obj[i] = null;
                    break;
                /* add key to inventory */


                case "TruckKey":
                    gp.playSE(20);
                    /* remove object from game */
                    gp.obj[i] = null;
                    gp.ui.showMessage("You picked up the keys to the truck!");
                    neededItems.remove("Truck Key");
                    break;
                case "Door":
                    if (hasKey > 0) {
                        gp.playSE(4);
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("You unlocked the door!");
                    } else {
                        gp.playSE(6);
                        gp.ui.showMessage("The door to the Tech Office is locked! You remember that HR has the key.");

                    }
                    break;
                case "Door1":
                    if (neededItems.size() == 0) {
                        gp.playSE(4);
                        gp.obj[i] = null;
                        gp.ui.showMessage("You unlocked the door!");
                    } else {
                        gp.playSE(6);
                        gp.ui.showMessage("You can't leave without the: " + String.valueOf(neededItems).replace("[", "").replace("]", "") + "!");

                    }
                    break;
                case "Truck":
                    truckFlag = true;
                    getPlayerImage();
                    gp.playSE(17);
                    gp.obj[i] = null;
                    gp.ui.showMessage("You crank up the truck. The faster we drive, the more cash we make - lets roll!");
                    direction = "up";
                    break;
                case "Thermos":
                    gp.playSE(3);
                    gp.ui.showMessage("Nice - you got your thermos! One step closer to getting on the road!");
                    gp.obj[i] = null;
                    neededItems.remove("Thermos");
                    break;
                case "Cash":
                    if (cashSE % 3 == 1) {
                        gp.playSE(23);
                    } else if (cashSE % 3 == 2) {
                        gp.playSE(16);
                    } else {
                        gp.playSE(2);
                    }
                    cashSE++;
                    gp.obj[i] = null;
                    int randomCash = (int) (Math.random() * 100) + 1;
                    gp.ui.showMessage(randomString + randomCash + "!");
                    playerMoney += randomCash;
                    break;

                case "Desk":
                    if (deskFlag) {
                        gp.playSE(3);
                        gp.ui.showMessage("You snag the Folder with your severance package while your boss sleeps at his desk, just in case...");
                        deskFlag = false;
                        neededItems.remove("Folder");
                        break;
                    }
                    break;
                case "Vending":
                    if (vendingFlag) {
                        gp.playSE(3);
                        vendingFlag = false;
                        gp.ui.showMessage("You got the soda from the vending machine! You drink it and feel a nice caffeine boost...");
                        speed += 2;
                        neededItems.remove("Soda");
                        break;
                    }
                    break;
                case "Coffee":
                    if (coffeeFlag) {
                        gp.playSE(18);
                        speed += 2;
                        coffeeFlag = false;
                        gp.ui.showMessage("You got your coffee! You feel POWER as caffeine courses through your veins...");
                        neededItems.remove("Coffee");
                        break;
                    }
                    break;
                /* HR rep female sprite in HR office */
                case "NPC1":
                    if (npc1Flag) {
                        gp.playSE(21);
                        hasKey++;
                        /* remove object from game */
                        npc1Flag = false;
                        gp.ui.showMessage("HR Coordinator: The radio and GPS in the truck are broken, take this key to the Tech Office to get the spares! ");
                        break;
                    } else {
                        gp.playSE(21);
                        gp.ui.showMessage("HR Coordinator: Safe travels!");

                    }
                    break;
                case "GPS":
                    gp.playSE(13);
                    gp.obj[i] = null;
                    gp.ui.showMessage("You got the GPS! You can now see your location. You are in Mississippi!");
                    neededItems.remove("GPS");
                    break;
                case "GasPump":
                    float gasByMoney = 100 - gasCount;
                    if (gasCount > 95) {
                        gp.playSE(8);
                        gp.ui.showMessage("You are already full on gas!");
                        break;
                    } else if (playerMoney == 0) {
                        gp.playSE(9);
                        gp.ui.showMessage("You don't have enough money to fill up your gas tank!");
                        break;

                    } else {
                        gp.playSE(3);
                        if (playerMoney >= gasByMoney) {
                            playerMoney -= gasByMoney;
                            gasCount = 100;
                            gp.ui.showMessage("You filled up your gas tank! It was $" + df.format(gasByMoney) + ", gas is expensive!");
                        } else {
                            gasCount += playerMoney;
                            playerMoney = 0;
                            gp.ui.showMessage("You use all of your money try to fill up your gas tank. You are out of cash!");
                        }
                        break;
                    }

                case "Package":
                    OBJ_Package shipping = (OBJ_Package) gp.obj[i];
                    if (!pickupPackage(shipping) && !deliverAndPickupPackage(shipping)) {
                        gp.playSE(8);
                        gp.ui.showMessage("You are currently in " + shipping.getState() + ". You need to go to " + getCurrentDestination() + ".");
                    }
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                } else {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                } else {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                } else {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }

    public void moveUp() {
        worldY -= speed;
    }

    public void moveDown() {
        worldY += speed;
    }

    public void moveLeft() {
        worldX -= speed;
    }

    public void moveRight() {
        worldX += speed;
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public State getNextDestination() {
        if (destinations.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int removeIndex = random.nextInt(destinations.size());
        int currentIndex = 0;

        Iterator<State> iter = destinations.iterator();
        while (iter.hasNext()) {
            State res = iter.next();

            if (currentIndex++ == removeIndex) {
                return res;
            }

        }


        return null;
    }

    public boolean pickupPackage(OBJ_Package pickup) {
        if (packagesInTrunck.size() > 0) {
            return false;
        }


        State currentState = pickup.getState();
        if (getCurrentDestination().getName().equals(currentState.getName())) {
            pickup.getPickedUp();
            gp.playSE(3);
            //removeDestination(currentState);
            pickup.setDestination(getNextDestination());
            packagesInTrunck.add(pickup);
            gp.ui.showMessage("You got the first package. First stop is " + getCurrentDestination().getName() + ". " + getCurrentDestination().getSaying());
            playerTimeMoney = UI.playTime;
            return true;
        }
        return false;
    }

    public boolean deliverAndPickupPackage(OBJ_Package pickup) {
        if (packagesInTrunck.size() == 0 || getCurrentDestination() == null) {
            return false;
        }

        State currentState = pickup.getState();

        if (getCurrentDestination().getName().equals(currentState.getName())) {
            removeDestination(getCurrentDestination());
            packagesInTrunck.clear();
            pickup.getPickedUp();
            pickup.setDestination(getNextDestination());
            packagesInTrunck.add(pickup);
            packageDelivered++;
            if (packageDelivered != winSetter) {
                gp.playSE(3);
            }

            double money = 300 - (UI.playTime - playerTimeMoney) < 100 ? 100 : 300 - (UI.playTime - playerTimeMoney);
            playerTimeMoney = UI.playTime;
            playerMoney += money;


            gp.ui.showMessage("You drop off in " + pickup.getState().getName() + ". You made: $" + df.format(money) + ". Next stop is " + getCurrentDestination() + "! " + getCurrentDestination().getSaying());
            //gp.ui.showMessage("You have delivered package in " +  deliverLocation.getState().getName() + "  !");
            return true;
        }


        return false;
    }

    public int getPackagesDelivered() {
        return packageDelivered;
    }

    public boolean removeDestination(State state) {
        return destinations.remove(state);
    }

    public double getPlayerMoney() {
        return playerMoney;
    }
}
