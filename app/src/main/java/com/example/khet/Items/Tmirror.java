package com.example.khet.Items;

public class Tmirror {
    int color;
    int posx, posy;
    int dir;

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

    public void rotate(){
        if(dir==0)
            dir = 1;
        else
            dir = 0;
    }

    public Tmirror() {
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

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Tmirror(int color, int posx, int posy, int dir) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
        this.dir = dir;
    }
}
