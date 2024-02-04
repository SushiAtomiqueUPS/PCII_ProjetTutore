package vue;

import model.Parcours;
import model.Position;
import model.Score;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Affichage extends JPanel {

    // Attribut pos de type postition qui contient la position de l'ovale
    private Position position;

    // Attribut ligne de type parcours qui contient la liste des points représentant la ligne brisée
    private Parcours ligne;

    // Attribut score de type score qui contient le score du joueur
    private Score score;

    // Constantes de la classe qui contiennent les dimensions de la fenêtre et les caractéristiques de l'ovale
    public static final int RATIO = 8;
    public static final int LARGEUR_OVALE = 35;
    public static final int LONGUEUR_OVALE = 100;
    public static final int APRES = 50;
    public static final int AVANT = 50;
    public static final int H = (Position.HAUTEUR_MAX-Position.HAUTEUR_MIN)*RATIO;
    public static final int L = 600;
    public static final int X = L/8;
    public static final int Y = H/4;


    /* Constructeur de la classe Affichage qui intialise l'attribut position de l'objet par l'argument p,
       l'attribut ligne par l'argument l et l'attribut score par l'argument s */
    public Affichage(Position p, Parcours l, Score s){
        this.setPreferredSize(new Dimension(L,H));
        this.position = p;
        this.ligne = l;
        this.score = s;
    }

    /* Méthode paint qui prend un élément graphique g et qui redessinne les éléments graphiques,
       en l'occurence le cercle ovale et la ligne brisée */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLUE);
        g.drawOval(X,(position.getHauteur()*RATIO/2)+Y/3, LARGEUR_OVALE, LONGUEUR_OVALE);

        //Dessine les lignes entres chaque points de la liste contenue dans ligne.getPoints() avec une boucle for
        //Affichage des points à refaire
        ArrayList<Point> points = ligne.getPoints();
        g.setColor(Color.RED);
        for (int i = 0; i < points.size()-1; i++) {
            g.drawLine((points.get(i).x), (points.get(i).y*RATIO/3)+Y,
                    (points.get(i+1).x), (points.get(i+1).y*RATIO/3)+Y);
        }
        //Affichage du score en haut à droite de la fenêtre
        g.setColor(Color.BLACK);
        g.drawString("Score : "+score.getScore(),L-100,20);
    }

    // Accesseur getPosition qui renvoie l'attribue position
    public Position getPosition() {
        return position;
    }
}


