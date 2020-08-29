package com.example.khet.Items;

public class Protector {
    int color;
    int posx,posy;

    public void up(){
        posy--;
    }

    public void down() {
        posy++;
    }

    public void left(){
        posx--;
    }
    public void right(){
        posx++;
    }

    public void ul(){
        posx--;
        posy--;
    }

    public void ur(){
        posx++;
        posy--;
    }
    public void dl(){
        posx--;
        posy++;
    }

    public void dr(){
        posx++;
        posy++;
    }

    public Protector() {
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
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

    public Protector(int color, int posx, int posy) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
    }
}
