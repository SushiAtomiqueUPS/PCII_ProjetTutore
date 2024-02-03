package model;

public class Position {
    public static final int HAUTEUR_MIN = 0;
    public static final int HAUTEUR_MAX = 70;
    public static final int HAUTEUR_OVALE = (HAUTEUR_MAX-HAUTEUR_MIN)/2;
    public static final int IMPULSION = 10;
    private int hauteur = HAUTEUR_OVALE;
    //private int vitesse = 0;
    private int avancement = 1;
    private boolean saut = false;


    //Accesseur qui renvoie l'attribut hauteur
    public int getHauteur() {
        return hauteur;
    }

    //Accesseur qui renvoie l'attribut avancement
    public int getAvancement() {
        return avancement;
    }

    //Méthode jump qui modifie l'attribut hauteur en lui additionnant la constante HAUTEUR et l'attribut vitesse,
    //augmente ausi la vitesse de 5
    public void jump(){
        if(this.hauteur > HAUTEUR_MIN){
            //vitesse -= IMPULSION;
            this.hauteur -= IMPULSION;
            this.saut = true;
            //for (int i = 0; i < IMPULSION; i++) {try {Thread.sleep(100);} catch (Exception e){e.printStackTrace();}}
        }
    }

    //Accesseur qui diminue l'attribut hauteur
    public void move(int h){
        if(this.hauteur < HAUTEUR_MAX && this.saut) {
            this.hauteur += h;
        }
    }

    //Accesseur qui augmente l'attribut avancement
    public void avance(){
        this.avancement += 1;
    }
}
