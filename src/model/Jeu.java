package model;
import javax.swing.*;

public class Jeu {
    //Classe principale du jeu avec l'ovale, la ligne brisée, le score et les Threads
    public static void main(String[] args) {
        //Initialisation des éléments nécessaires au fonctionnement du jeux
        JFrame maFenetre = new JFrame("Cercle");
        Position pos = new Position();
        Parcours ligne = new Parcours(pos);
        Score score = new Score();
        vue.Affichage a = new vue.Affichage(pos,ligne, score);
        vue.Redessine redessine = new vue.Redessine(a);
        model.Descendre descend = new model.Descendre(pos);
        AvanceLigne avance = new AvanceLigne(pos);

        //Ajoute à la fenêtre de jeu, l'affichage et le controleur
        maFenetre.add(redessine.getMonAffichage());
        maFenetre.addMouseListener(new control.ReactionClic(redessine.getMonAffichage().getPosition()));

        //Démmarrage des Threads : redessine, descend, avance et score
        redessine.start();
        descend.start();
        avance.start();
        score.start();

        //Quelques paramètres pour faire fonctionner le JFrame et le fermer correctement
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.pack();
        maFenetre.setVisible(true);
    }
}
