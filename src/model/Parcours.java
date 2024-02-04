package model;
import vue.Affichage;

import java.awt.*;
import java.util.ArrayList;
public class Parcours {

    // Constante X_MIN qui est la borne inférieur de l'écart en x entre chaque point de la ligne brisée
    public static final int X_MIN = 20;

    // Constante X_MAX qui est la borne supérieur de l'écart en x entre chaque point de la ligne brisée
    public static final int X_MAX = 40;

    // Attribut pos de type postition qui contient la position de l'ovale
    private Position pos;

    // Attribut de type ArrayList<Point> qui contient les points de la ligne brisée
    private ArrayList<Point> points;


    // Accesseur qui renvoie l'attribut points après avoir fait défiler la ligne brisée et mis à jour les points
    public ArrayList<Point> getPoints() {
        this.defile();
        if(points.get(1).x < -Affichage.AVANT) points.remove(1);
        if(points.get(points.size()-1).x < Affichage.L)
            points.add(new Point(Affichage.L+Affichage.APRES,
                                 (int) (Math.random() * (Position.HAUTEUR_MAX-20))+10));
        return points;
    }

    /* Constructeur Parcours qui initialise l'attribut points en créant un tableau de points croissant, chaque points
    * doit avoir sa coordonnée x espacée d'une valeur entre X_MIN et X_MAX et on crée des points
    * tant que x < largeur de la fenêtre et que le tableau n'est pas rempli jusq'à la taille-2
    * On complète le tableau avec des points qui ont une coordonnée x croissante et une coordonnée y aléatoire
    * et un dernier point en dehors de la fenêtre pour que le joueur voit la ligne brisée sans interruption
    */
    public Parcours(Position p){
        int i = 2;
        int taille = 20;
        //c'est la coordonnée du premier point visible
        int x_premierpoint = Affichage.AVANT*4;
        //x est une valeur aléatoire compris entre X_min et X_MAX + la coordonnée du premier point visible
        int x = (int) (Math.random() * (X_MAX-X_MIN)) + X_MIN + x_premierpoint;
        //Initialisation du tableau de points
        points = new ArrayList<>(taille);
        /* Ajout des deux premiers points, le premier est en dehors de la fenêtre pour que
        le joueur voit la ligne brisée sans interruption */
        points.add(0,new Point(0-Affichage.AVANT,Position.HAUTEUR_OVALE));
        points.add(1,new Point(x_premierpoint, points.get(0).y));
        //Créer les points jusqu'à ce que x soit supérieur à la largeur de la fenêtre
        while(x < Affichage.L && i < taille-2){
            x += (int) (Math.random() * (X_MAX-X_MIN))+X_MIN;
            if (i%2==0) points.add(i,new Point(x, points.get(i-1).y));
            else points.add(i,new Point(x, (int) (Math.random() * (Position.HAUTEUR_MAX-20))+10));
            i++;
        }
        //Créer les points restants entre i et points.length-1
        for (int j = i; j < taille-1; j++) {
            points.add(j,new Point(points.get(j-1).x+1,points.get(j-1).y));
        }
        //Ajout du dernier point en dehors de la fenêtre pour que le joueur voit la ligne brisée sans interruption
        points.add(taille-1, new Point(Affichage.L+Affichage.APRES,points.get(taille-2).y));
        //Initialisation de l'attribut pos
        pos = p;
    }

    // Méthode qui modifie tous les points pour faire défiler la ligne brisée vers la gauche
    public void defile(){
        for (int i = 0; i < points.size(); i++) {
            points.get(i).x -= pos.getAvancement();
        }
    }
}
