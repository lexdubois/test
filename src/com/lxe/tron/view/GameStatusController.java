package com.lxe.tron.view;

public interface GameStatusController {


    public void start() throws InterruptedException;
    public void stop();
    public void suspend();
    public void resume();
}
