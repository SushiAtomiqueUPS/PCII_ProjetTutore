package main;

import model.Jeu;

import javax.swing.*;
import java.awt.*;

public class Main {

    // Main du menu principal
    public static void main(String[] args) {
        //Fenêtre avec pour titre Cercle et de taille 500x500
        javax.swing.JFrame fenetre = new javax.swing.JFrame("Cercle");
        fenetre.setPreferredSize(new Dimension(500,500));
        fenetre.setLayout(new java.awt.GridLayout(5,3));
        //Création d'un bouton Commencer au centre de la fenêtre
        JButton Commencer = new JButton("Commencer");
        //Action du bouton start : lancement du main du jeu
        Commencer.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fenetre.setVisible(false);
                Jeu.main(args);
            }
        });
        //Création d'un bouton leaderboards en dessous du bouton start
        //JButton leaderboards = new JButton("Leaderboards");
        fenetre.add(Commencer);
        //fenetre.add(leaderboards);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.pack();
        fenetre.setVisible(true);
    }

}