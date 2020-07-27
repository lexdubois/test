package com.lxe.tron.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SplashPanel extends JPanel {
    private Object keyPressedToken = new Object();
    protected KeyEventHandler keyHandler = new KeyEventHandler();
    protected JButton splashButton;

    public SplashPanel() {
        this.setPreferredSize(new Dimension(1000, 700));
        this.setMinimumSize(new Dimension(1000, 700));
        this.setLayout(new BorderLayout());
        splashButton = new JButton(new ImageIcon("D:\\tronGame\\res\\Tron.PNG"));
        splashButton.setMinimumSize(new Dimension(400, 170));
        splashButton.setPreferredSize(new Dimension(400, 170));
        splashButton.setMaximumSize(new Dimension(400, 170));
        this.add(splashButton, BorderLayout.CENTER);
    }

    public void showSplash() throws InterruptedException {

        this.addKeyListener(keyHandler);
        this.grabFocus();
        splashButton.addKeyListener(keyHandler);
        synchronized (keyPressedToken){
            keyPressedToken.wait();
        };
        splashButton.removeKeyListener(keyHandler);
        this.removeKeyListener(keyHandler);
    }

    public void waitForCompletion() {
//        TODO: wait on Key pressed token, unbind listeners
    }

    public class KeyEventHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            synchronized (keyPressedToken) {
                keyPressedToken.notifyAll();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

}
