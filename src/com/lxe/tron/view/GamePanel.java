package com.lxe.tron.view;

import com.lxe.tron.model.Direction;
import com.sun.jdi.Value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    protected GameEventHandler gameHandler = new GameEventHandler();
    private int x = 500;
    private int y = 350;
    private int x2= 500;
    private int y2= 360;


    public GamePanel() {
        this.setPreferredSize(new Dimension(1920, 1200));
        this.setMinimumSize(new Dimension(1920, 1200));
        this.setLayout(new BorderLayout());
        this.setBackground(Color.MAGENTA);

    }

    protected void paintComponent (Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(x, y, x2, y2);
        x = x2;
        y = y2;
    }

    public void updateTrace(Direction d, int v) {
        if(d == Direction.UP) {
            y2 += v;
            repaint();
        }
        if(d == Direction.LEFT) {
            x2 -= v;
            repaint();
        }
        if(d == Direction.DOWN) {
            y2 -= v;
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
            if (e.getKeyCode() == KeyEvent.VK_W) {
                updateTrace(Direction.UP, 10);
            }
            if (e.getKeyCode() == KeyEvent.VK_A) {
                updateTrace(Direction.LEFT, 10);

            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                updateTrace(Direction.DOWN, 10);

            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                updateTrace(Direction.RIGHT, 10);

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }



}
