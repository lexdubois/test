package com.lxe.tron.view;

import com.lxe.tron.model.Trace;

public class HumanTraceAnimator implements GameStatusController, Runnable {

    protected Thread traceAnimator;
    protected Trace trace;
    protected GamePanel gamePanel;

    public HumanTraceAnimator(Trace trace, GamePanel gamePanel) {
        this.trace = trace;
        this.gamePanel = gamePanel;
    }

    private boolean stopped;
    protected long refreshRate = 250;

    @Override
    public void start() {
        if (!(traceAnimator==null)) throw new IllegalStateException("Check your fucking code dude!");
        traceAnimator = new Thread(this);
        stopped = false;
        traceAnimator.start();
    }

    @Override
    public void stop() {
        stopped = true;
    }

    @Override
    public void suspend() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void run() {
        while (stopped == false) {


            gamePanel.updateTrace(trace.getDirection(), 5);

            synchronized(this) {
                try {
                    this.wait(refreshRate);
                }
                catch (InterruptedException ie) {
                    stopped = true;
                }

            }

        }


    }

}
