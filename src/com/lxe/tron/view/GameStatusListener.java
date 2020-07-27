package com.lxe.tron.view;

public interface GameStatusListener {
    public static Integer PENDING = 1;
    public static Integer STARTED = 2;
    public static Integer SUSPENDED = 3;
    public static Integer STOPPED = 4;


    public void gameStatusChanged(Integer status);
}
