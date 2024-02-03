package view;

public class Redessine extends Thread{
    private Affichage monAffichage;
    public static final int DELAY = 50;

    //Constructeur qui initialise l'attribut monAffichage par l'argument a
    public Redessine(Affichage a){
        this.monAffichage = a;
    }

    //Méthode run qui lance un Thread pour mette à jour l'affichage de la fenêtre
    @Override
    public void run(){
        while(true) {
            try { Thread.sleep(this.DELAY); }
            catch (Exception e) { e.printStackTrace(); }
            monAffichage.revalidate();
            monAffichage.repaint();
        }
    }

    //Accesseur qui renvoie l'attribut monAffichage de l'objet
    public Affichage getMonAffichage() {
        return monAffichage;
    }
}
