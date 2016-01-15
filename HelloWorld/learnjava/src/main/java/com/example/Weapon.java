package com.example;

/**
 * Created by apahlavan1 on 1/5/2016.
 */
public class Weapon {
    private String name;
    private int damageInflicted;
    private int hitPoints;

    public Weapon(){
        setName("Unknown Weapon");
        setHitPoints(0);
        setDamageInflicted(0);
    }
    public Weapon(String name, int damageInflicted, int hitPoints) {
        this.damageInflicted = damageInflicted;
        this.hitPoints = hitPoints;
        this.name = name;
    }

    public void setDamageInflicted(int damageInflicted) {
        this.damageInflicted = damageInflicted;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setupWeapon(String name, int dmg, int hitPnts){
        this.setName(name);
        this.setDamageInflicted(dmg);
        this.setHitPoints(hitPnts);
    }

    public int getDamageInflicted() {

        return damageInflicted;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getName() {
        return name;
    }
    public void setWeapon(Weapon weapon) {
        this.setDamageInflicted(weapon.getDamageInflicted());
        this.setHitPoints(weapon.getHitPoints());
        this.setName(weapon.getName());
    }
}
