package com.lxe.tron.model;

public class Player {

    String color;
    int x;
    int y;
    public Direction direction;

    public Player(String color, int x, int y, Direction direction) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getColor() { return color; }

    public int getX() { return x; }

    public int getY() { return y; }

    public Direction getDirection() { return direction; }

    public void setColor(String color) { this.color = color; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void setDirection(Direction direction) { this.direction = direction; }

}
