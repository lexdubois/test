package com.lxe.tron.view;

import com.lxe.tron.model.Direction;
import com.lxe.tron.model.Trace;
import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    protected GameEventHandler gameHandler = new GameEventHandler();

    protected Trace trace;

    private int x;
    private int y;
    private int x2;
    private int y2;


    public GamePanel(Trace trace) {
        super();
        this.trace = trace;

        this.x  = (int) trace.getTraceHead().getX();
        this.y  = (int) trace.getTraceHead().getY();
        this.x2 = (int) trace.getTraceHead().getX();
        this.y2 = (int) trace.getTraceHead().getY();

        this.setPreferredSize(new Dimension(1920, 1200));
        this.setMinimumSize(new Dimension(1920, 1200));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.MAGENTA);
        GameEventHandler listener = new GameEventHandler();
        this.addKeyListener(listener);
        this.setFocusable(true);
    }

    protected void paintComponent (Graphics g) {
        System.out.println("paintC: x: " + x + ", y: " + y);
        g.setColor(Color.BLUE);
        g.drawLine(x, y, x2, y2);
        x = x2;
        y = y2;
    }

    public void updateTrace(Direction d, int v) {

        System.out.println("updateTrace: d: " + d + ", v: " +v);


        if(d == Direction.UP) {
            y2 -= v;
            repaint();
        }
        if(d == Direction.LEFT) {
            x2 -= v;
            repaint();
        }
        if(d == Direction.DOWN) {
            y2 += v;
            repaint();
        }
        if(d == Direction.RIGHT) {
            x2 += v;
            repaint();
        }

    }

    public class GameEventHandler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            System.out.println("Keypressed: " +e);
            if (e.getKeyCode() == KeyEvent.VK_W) { trace.setDirection(Direction.UP); }
            else if (e.getKeyCode() == KeyEvent.VK_A) { trace.setDirection(Direction.LEFT); }
            else if (e.getKeyCode() == KeyEvent.VK_S) { trace.setDirection(Direction.DOWN); }
            else if (e.getKeyCode() == KeyEvent.VK_D) { trace.setDirection(Direction.RIGHT); }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

//    public static void main(String[] args) {
//        GamePanel game = new GamePanel();
//        game.updateTrace(Direction.UP, 100);
//        game.updateTrace(Direction.UP, 100);
//        game.updateTrace(Direction.UP, 100);
//        game.updateTrace(Direction.RIGHT, 100);
//        game.updateTrace(Direction.RIGHT, 100);
//        System.out.printf("\nx2: %d", game.x2);
//        System.out.printf("\ny2: %d", game.y2);
//
//
//    }



}
