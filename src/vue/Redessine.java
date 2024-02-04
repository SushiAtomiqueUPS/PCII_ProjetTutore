package vue;

public class Redessine extends Thread{

    // Attribut monAffichage de type Affichage qui représente la fenêtre de jeu
    private Affichage monAffichage;

    // Constante de la classe qui représente le délai entre chaque redessinage de la fenêtre
    public static final int DELAY = 50;

    // Constructeur qui initialise l'attribut monAffichage par l'argument a
    public Redessine(Affichage a){
        this.monAffichage = a;
    }

    // Méthode run qui lance un Thread pour mette à jour l'affichage de la fenêtre toutes les DELAY millisecondes
    @Override
    public void run(){
        while(true) {
            try { Thread.sleep(this.DELAY); }
            catch (Exception e) { e.printStackTrace(); }
            monAffichage.revalidate();
            monAffichage.repaint();
        }
    }

    // Accesseur qui renvoie l'attribut monAffichage de l'objet
    public Affichage getMonAffichage() {
        return monAffichage;
    }
}
