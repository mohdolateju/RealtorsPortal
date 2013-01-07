/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

/**
 *
 * @author Mohammed
 * This class contains the parameter for information in the subscription package
 * table
 */
public class PackageBean {

    private String subPackage;
    private int duration;
    private float price;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    public String getSubPackage() {
        return subPackage;
    }

    public void setSubPackage(String subPackage) {
        this.subPackage = subPackage;
    }

}
