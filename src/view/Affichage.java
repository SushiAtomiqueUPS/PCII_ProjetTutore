package view;

import model.Parcours;
import model.Position;
import model.Score;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {
    private Position position;
    private Parcours ligne;
    private Score score;
    public static final int RATIO = 8;
    public static final int WIDTH = 35;
    public static final int HEIGHT = 100;
    public static final int AFTER = 50;
    public static final int BEFORE = 50;
    public static final int H = (Position.HAUTEUR_MAX-Position.HAUTEUR_MIN)*RATIO;
    public static final int L = 600;
    public static final int X = L/8;
    public static final int Y = H/4;


    //Constructeur de la classe view.Affichage qui intialise l'attribut position de l'objet par l'argument p
    public Affichage(Position p, Parcours l, Score s){
        this.setPreferredSize(new Dimension(L,H));
        this.position = p;
        this.ligne = l;
        this.score = s;
    }

    /*Méthode paint qui prend un élément graphique g et qui redessinne les éléments graphiques,
    en l'occurence le cercle ovale*/
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.drawOval(X,(position.getHauteur()*RATIO/2)+Y/3,WIDTH,HEIGHT);

        //Dessine les lignes entres chaque points de la liste contenue dans ligne.getPoints() avec une boucle for
        //Affichage des points à refaire
        ArrayList<Point> points = ligne.getPoints();
        g.setColor(Color.RED);
        for (int i = 0; i < points.size()-1; i++) {
            g.drawLine((points.get(i).x), (points.get(i).y*RATIO/3)+Y, (points.get(i+1).x), (points.get(i+1).y*RATIO/3)+Y);
        }
        //Affichage du score en haut à droite de la fenêtre
        g.setColor(Color.BLACK);
        g.drawString("Score : "+score.getScore(),L-100,20);
    }

    //Accesseur qui renvoie l'attribue position
    public Position getPosition() {
        return position;
    }
}


