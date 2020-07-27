package com.lxe.tron.model;

public class Coords{
    double x;
    double y;
    Direction direction;


    public Coords(double x, double y){
        this.x = x;
        this.y = y;
    }

//    public void setX(double x) {
//        this.x = x;
//    }
////
//    public void setY(double y) {
//        this.y = y;
//    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Coords c) {
        return Math.sqrt(Math.pow(c.getX() - this.getX(), 2) + (Math.pow(c.getY() - this.getY(), 2)));
    }

    public static double getDistanceBetween(Coords c1, Coords  c2) {
        return c1.distanceTo(c2);
    }



}
