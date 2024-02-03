package model;

import view.Affichage;

public class Descendre extends Thread{
    private Position pos;
    private static final int HAUTEUR = 2;

    //Constructeur model.Descendre qui initialise l'attribut pos par l'argument pos
    public Descendre(Position pos){ this.pos = pos;}

    //Méthode run qui lance un Thread et qui fait descendre l'ovale toutes les 100ms
    @Override
    public void run(){
        while(true){
            try {Thread.sleep(100);}
            catch (Exception e){e.printStackTrace();}
            this.pos.move(this.HAUTEUR);
        }
    }
}
