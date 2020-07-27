package com.lxe.tron.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TronGUI extends JFrame{
    JPanel mainPanel = new JPanel();
    JButton button = new JButton(new ImageIcon("D:\\tronGame\\src\\View\\Tron.PNG"));



    public static void main(String[] args) {
        new TronGUI("Tron 2.0");

    }

    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased=" + KeyEvent.getKeyText(e.getKeyCode()));

        }
    }

    public TronGUI(String title){
        super(title);
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
        setSize(1200,900);
        button.setBounds(350,500,450,180);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Game Starting..");
            }
        });
        setLayout(null);
        add(button);
        add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        };

}



