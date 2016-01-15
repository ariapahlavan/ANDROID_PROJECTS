package com.example;

import java.util.ArrayList;

/**
 * Created by apahlavan1 on 1/5/2016.
 */
public class Player {
    private String handleName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapons;
    private ArrayList<InventoryItem> inventoryItems;

    public  Player(){
        handleName = "Unknown player";
        //prevent hard-coding
        setLives(3);
        setLevel(1);
        setScore(0);
        setDefaultWeapon();
        setupInventoryItem();
    }


    public Player(String handleName){
        //No hard-coding
        this();
        setHandleName(handleName);

    }

//    public void setInventoryItems(ArrayList<InventoryItem> inventoryItems) {
//        this.inventoryItems = inventoryItems;
//    }

    public void addInventoryItem(InventoryItem inventoryItem){
        this.inventoryItems.add(inventoryItem);
    }

    public boolean dropInventoryItem(InventoryItem inventoryItem){
        //if found delete and return true, else return false
        if(this.inventoryItems.contains(inventoryItem)) {
            this.inventoryItems.remove(inventoryItem);
            return true;
        }

        return false;
    }

    public ArrayList<InventoryItem> getInventoryItems() {

        return inventoryItems;
    }

    public void setupInventoryItem(){
        this.inventoryItems = new ArrayList<InventoryItem>();
    }

    public void setWeapons(Weapon weapons) {
        this.weapons.setWeapon(weapons);
    }

    public Weapon getWeapons() {

        return weapons;
    }

    public void setDefaultWeapon(){

        this.weapons = new Weapon("New Weapon", 0, 0);
    }

    public void setupWeapon(String name, int dmg, int hitPnts){
        this.weapons.setupWeapon(name, dmg, hitPnts);
    }

    public void setHandleName(String handleName) {
        //Validation
        if(handleName.length() >= 4) {
            this.handleName = handleName;
        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getHandleName() {
        return handleName;
    }

    public int getLevel() {
        return level;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }
}
