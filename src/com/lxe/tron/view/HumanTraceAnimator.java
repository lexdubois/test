package com.lxe.tron.view;

import com.lxe.tron.model.Trace;

public class HumanTraceAnimator implements GameStatusController {

    protected Thread traceAnimator;
    protected Trace trace;

    public HumanTraceAnimator(Trace trace) {
        this.trace = trace;
    }


    @Override
    public void start() {
        traceAnimator = new Thread(new AnimatorThread());
    }

    @Override
    public void stop() {

    }

    @Override
    public void suspend() {

    }

    @Override
    public void resume() {

    }

    protected class AnimatorThread implements Runnable, GameStatusController {

        @Override
        public void run() {

        }

        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }

        @Override
        public void suspend() {

        }

        @Override
        public void resume() {

        }
    }
}
