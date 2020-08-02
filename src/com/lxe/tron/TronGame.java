package com.lxe.tron;

import com.lxe.tron.model.Coords;
import com.lxe.tron.model.Direction;
import com.lxe.tron.model.Trace;
import com.lxe.tron.view.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TronGame implements GameStatusController {

    public static void main(String[] args) throws InterruptedException {
//        lire les parametres de ligne de commande
//        show splash screen wait for key pressed
        TronGame tronGame = new TronGame();
        tronGame.start();
    }


    protected JFrame gameFrame = new JFrame();
    protected List<GameStatusListener> gameStatusListeners = new ArrayList<GameStatusListener>();

    public TronGame() {
//        Gestion des parametres recus de la ligne de commande
//        Creation des objets du jeu: panneau de jeu, interface, splash screen, decompte, animateur, etc
    }

    @Override
    public void start() throws InterruptedException {
//        TODO: afficher le countdown
//        TODO: envoyer l'evenement de demarrage

        SplashPanel splash = new SplashPanel();

        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().add(splash, BorderLayout.CENTER);
        gameFrame.pack();
        gameFrame.setVisible(true);
        splash.showSplash();
        gameFrame.remove(splash);

        Trace trace = new Trace(new Coords(500, 350), Direction.UP);
        GamePanel gamePanel = new GamePanel(trace);
        HumanTraceAnimator traceAnimator = new HumanTraceAnimator(trace, gamePanel);


        gameFrame.add(gamePanel);
        gameFrame.repaint();
        gamePanel.grabFocus();


        traceAnimator.start();

//        JLabel tempLabel = new JLabel("!! Game Panel Here !!");
//        tempLabel.setForeground(Color.DARK_GRAY);
//        tempLabel.setBackground(Color.CYAN.darker());
//        tempLabel.setHorizontalAlignment(JLabel.CENTER);
//        tempLabel.setVerticalAlignment(JLabel.CENTER);
//        tempLabel.setFont((tempLabel.getFont()).deriveFont(80));
//        gameFrame.getContentPane().add(tempLabel, BorderLayout.CENTER);


        gameFrame.revalidate();

    }

    @Override
    public void stop() {
//        TODO: envoyer l'evenement d'arret

    }

    @Override
    public void suspend() {
//        TODO: envoyer l'evenement de suspension

    }

    @Override
    public void resume() {
//        TODO: envoyer l'evenement de reprise

    }



    protected void addGameStatusChangedListener(GameStatusListener l) {
        if (!gameStatusListeners.contains(l) )gameStatusListeners.add(l);

    }

    protected void removeGameStatusChangedListener(GameStatusListener l) {
        if (gameStatusListeners.contains(l) )gameStatusListeners.remove(l);
    }

    protected void fireGameStatusChangedEvent(Integer status) {
        for (GameStatusListener l : gameStatusListeners) {
            l.gameStatusChanged(status);
        }

    }
}
