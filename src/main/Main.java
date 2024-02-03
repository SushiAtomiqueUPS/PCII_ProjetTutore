package main;

import model.Jeu;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Fenêtre avec pour titre Circle et de taille 500x500
        javax.swing.JFrame fenetre = new javax.swing.JFrame("Circle");
        fenetre.setPreferredSize(new Dimension(500,500));
        fenetre.setLayout(new java.awt.GridLayout(5,3));
        //Création d'un bouton start au centre de la fenêtre
        JButton start = new JButton("Start");
        //Action du bouton start : lancement du main du jeu
        start.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fenetre.setVisible(false);
                Jeu.main(args);
            }
        });
        //Création d'un bouton leaderboards en dessous du bouton start
        //JButton leaderboards = new JButton("Leaderboards");
        fenetre.add(start);
        //fenetre.add(leaderboards);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack();
        fenetre.setVisible(true);
    }

}