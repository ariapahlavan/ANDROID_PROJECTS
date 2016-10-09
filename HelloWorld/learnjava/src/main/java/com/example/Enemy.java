package com.example;

/**
 * Created by apahlavan1 on 1/6/2016.
 */
public class Enemy {
    private int hitPoints;
    private int lives;

    public Enemy(int hitPoints, int lives) {
        this.hitPoints = hitPoints;
        this.lives = lives;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void takeDamage(int damage){
        int currHitPoints = getHitPoints();
        int remainingHitPoints;
        if(currHitPoints > damage) {
            remainingHitPoints = currHitPoints - damage;
        } else remainingHitPoints = 0;

        setHitPoints(remainingHitPoints);
        System.out.println("I took " + damage + " points damage, and have "
                            + remainingHitPoints + " left.");

    }
}
