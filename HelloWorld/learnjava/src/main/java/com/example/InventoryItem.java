package com.example;

/**
 * Created by apahlavan1 on 1/6/2016.
 */


enum ItemType{
    POTION,
    RING,
    ARMOR,
    NONE
}

public class InventoryItem {

    private  ItemType type;
    private String name;

    public InventoryItem() {
        setName("Unknown item");
        setType(ItemType.NONE);
    }

    public InventoryItem(String name, ItemType type) {
        setName(name);
        setType(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ItemType getType() {
        return type;
    }
}
