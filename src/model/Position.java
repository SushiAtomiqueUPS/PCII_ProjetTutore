package model;

public class Position {

    // Constantes HAUTEUR_MIN et HAUTEUR_MAX qui définissent les limites de hauteur de l'ovale
    public static final int HAUTEUR_MIN = 0;
    public static final int HAUTEUR_MAX = 70;

    // Constante HAUTEUR_OVALE qui définit la hauteur de l'ovale au début du jeu, utilisé par la ligne brisée
    public static final int HAUTEUR_OVALE = (HAUTEUR_MAX-HAUTEUR_MIN)/2;

    // Constante IMPULSION qui définit la taille du saut de l'ovale
    public static final int IMPULSION = 10;

    // Attributs hauteur pour faire varier la hauteur de l'ovale
    private int hauteur = HAUTEUR_OVALE;

    // Attribut avancement pour faire avancer la ligne brisée
    private int avancement = 1;

    // Attribut saut définir le début de la chute
    private boolean saut = false;


    // Accesseur qui renvoie l'attribut hauteur
    public int getHauteur() {
        return hauteur;
    }

    // Accesseur qui renvoie l'attribut avancement
    public int getAvancement() {
        return avancement;
    }

    // Méthode saut qui modifie l'attribut hauteur en lui soustrayant la constante IMPULSION
    public void saut(){
        if(this.hauteur > HAUTEUR_MIN){
            this.hauteur -= IMPULSION;
            this.saut = true;
        }
    }

    // Accesseur chute qui augmente l'attribut hauteur pour faire descendre l'ovale
    public void chute(int h){
        if(this.hauteur < HAUTEUR_MAX && this.saut) {
            this.hauteur += h;
        }
    }

    // Accesseur qui augmente l'attribut avancement pour accélérer la ligne brisée
    public void avance(){
        this.avancement += 1;
    }
}
