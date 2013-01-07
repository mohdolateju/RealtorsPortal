/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.bean;

import java.util.ArrayList;

/**
 *
 * @author Mohammed
 * These parameters' sotr subsscipttion package data thas will
 * be used in the Registration page
 */
public class LoadRegBean {

    private ArrayList sub_package;
    private ArrayList duration;
    private ArrayList price;

    public ArrayList getPrice() {
        return price;
    }

    public void setPrice(ArrayList price) {
        this.price=price;
    }


    public ArrayList getDuration() {
        return duration;
    }

    public void setDuration(ArrayList duration) {
        this.duration=duration;
    }


    public ArrayList getSub_package() {
        return sub_package;
    }

    public void setSub_package(ArrayList sub_package) {
        this.sub_package=sub_package;
    }

}
