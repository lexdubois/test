package com.lxe.tron.controller;
import com.lxe.tron.model.Direction;
import com.lxe.tron.model.Player;

public class PlayerController {
    protected Player player;

    public PlayerController(Player player){
        this.player = player;
    }

    public void move(Direction direction) {
        player.direction = direction;
        player.setX(player.getX()+direction.getDeltaX());
        player.setY(player.getY()+direction.getDeltaY());
    }

}

