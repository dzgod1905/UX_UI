package com.nftapp.nftmarketplace.model;

import java.io.Serializable;

public class Item implements Serializable {
    public int id;
    public int resourceImage;
    public String item_name;


    public Item(int id, int resourceImage, String item_name) {
        this.id = id;
        this.resourceImage = resourceImage;
        this.item_name = item_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getItem_name() {
        return item_name;
    }


    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

}
