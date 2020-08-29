package com.example.khet.Items;

public class Protector {
    String color;
    int posx,posy;

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

    public Protector(String color, int posx, int posy) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
    }
}
