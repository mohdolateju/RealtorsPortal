
package com.myapp.bean;

import java.util.ArrayList;

/**
 *
 * @author Mohammed
 * This is where all the data from the ads table are stored
 */
public class AllAdsBean {

private ArrayList imagePath;
private ArrayList category;
private ArrayList type;
private ArrayList location;
private ArrayList description;

    public ArrayList getCategory() {
        return category;
    }

    public void setCategory(ArrayList category) {
        this.category = category;
    }

    public ArrayList getDescription() {
        return description;
    }

    public void setDescription(ArrayList description) {
        this.description = description;
    }

    public ArrayList getImagePath() {
        return imagePath;
    }

    public void setImagePath(ArrayList imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList getLocation() {
        return location;
    }

    public void setLocation(ArrayList location) {
        this.location = location;
    }

    public ArrayList getType() {
        return type;
    }

    public void setType(ArrayList type) {
        this.type = type;
    }


}
