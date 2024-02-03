package model;
import view.Affichage;

import java.awt.*;
import java.util.ArrayList;
public class Parcours {
    /* Constante X_MIN */
    public static final int X_MIN = 20;
    /* Constante X_MAX */
    public static final int X_MAX = 40;

    /* Attribut pos de type postition qui stocke la position du joueur*/
    private Position pos;

    /*Attribut de type ArrayList<Point> qui stocke les points du parcours*/
    private ArrayList<Point> points;

    //Accesseur qui renvoie l'attribut points
    public ArrayList<Point> getPoints() {
        this.move();
        if(points.get(1).x < -Affichage.BEFORE) points.remove(1);
        if(points.get(points.size()-1).x < Affichage.L) points.add(new Point(Affichage.L+Affichage.AFTER,(int) (Math.random() * (Position.HAUTEUR_MAX-20))+10));
        return points;
    }

    /* Constructeur Parcours qui initialise l'attribut points en créant un tableau de points croissant, chaque points
    * doit avoir sa coordonnée x espacée d'une valeur entre X_MIN et X_MAX et on crée des points
    * tant que x < largeur de la fenêtre
    */
    public Parcours(Position p){
        int i = 2;
        int taille = 20;
        //c'est la coordonnée du premier point visible
        int x_premierpoint = Affichage.BEFORE*4;
        //x est une valeur aléatoire compris entre X_min et X_MAX + la coordonnée du premier point visible
        int x = (int) (Math.random() * (X_MAX-X_MIN)) + X_MIN + x_premierpoint;
        //Initialisation du tableau de points
        points = new ArrayList<>(taille);
        //Ajout des deux premiers points, le premier est en dehors de la fenêtre pour que le joueur voit la ligne brisée
        //sans interruption
        points.add(0,new Point(0-Affichage.BEFORE,Position.HAUTEUR_OVALE));
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
        points.add(taille-1, new Point(Affichage.L+Affichage.AFTER,points.get(taille-2).y));
        //Initialisation de l'attribut pos
        pos = p;
    }

    /* Méthode qui modifie tous les points pour faire défiler la ligne brisée vers la gauche*/
    public void move(){
        for (int i = 0; i < points.size(); i++) {
            points.get(i).x -= pos.getAvancement();
        }
    }

    /* main qui teste ce constructeur
    public static void main(String[] args) {
        Parcours p = new Parcours(null);
        for (int i = 0; i < p.points.size(); i++) System.out.println(p.points.get(i));
    }*/
}
