package model;
import javax.swing.*;

public class Jeu {
    public static void main(String[] args) {
        //Initialisation des éléments nécessaires au fonctionnement du jeux
        JFrame maFenetre = new JFrame("Circle");
        Position pos = new Position();
        Parcours ligne = new Parcours(pos);
        Score score = new Score();
        view.Affichage a = new view.Affichage(pos,ligne, score);
        view.Redessine anim = new view.Redessine(a);
        model.Descendre descend = new model.Descendre(pos);
        AvanceLigne avance = new AvanceLigne(pos);

        //Ajout au la fenêtre JFrame de la vue qui est a et du contrôleur
        maFenetre.add(anim.getMonAffichage());
        maFenetre.addMouseListener(new control.ReactionClic(anim.getMonAffichage().getPosition()));

        //Démarrage des Threads : redessinne, descend et avance
        anim.start();
        descend.start();
        avance.start();
        score.start();

        //Quelques paramètres pour faire fonctionner le JFrame et le fermer correctement
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maFenetre.pack();
        maFenetre.setVisible(true);
    }
}
