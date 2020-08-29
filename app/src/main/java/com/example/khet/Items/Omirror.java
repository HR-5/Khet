package com.example.khet.Items;

public class Omirror {

    String color;
    int posx,posy;
    int dir;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Omirror(String color, int posx, int posy, int dir) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
        this.dir = dir;
    }
}
