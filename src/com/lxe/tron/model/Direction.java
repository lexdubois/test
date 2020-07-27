package com.lxe.tron.model;

import java.util.HashSet;
import java.util.Set;

public class Direction {

    private static Set constants = new HashSet();

    public static final Direction UP    = new Direction( 0,  1, "UP");
    public static final Direction DOWN  = new Direction( 0, -1, "DOWN");
    public static final Direction LEFT  = new Direction( 1,  0, "LEFT");
    public static final Direction RIGHT = new Direction(-1,  0, "RIGHT");

    protected int deltaX, deltaY;
    protected String name;

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }


    private Direction(int dx, int dy, String name)
    {
        this.deltaX = dx;
        this.deltaY = dy;
        this.name = name;

    }
    public String toString(){
        return name;
    }

}
