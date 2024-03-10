package com.nftapp.nftmarketplace.model;

import java.io.Serializable;

public class Feature implements Serializable {
    public int resourceImage;
    public String feature_name;


    public Feature(int resourceImage, String feature_name) {
        this.resourceImage = resourceImage;
        this.feature_name = feature_name;

    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public void setFeature_name(String feature_name) {
        this.feature_name = feature_name;
    }
}
