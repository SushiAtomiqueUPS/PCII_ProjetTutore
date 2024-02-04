package model;

public class AvanceLigne extends Thread{

    // Attribut pos de type postition qui contient la position de l'ovale
    Position pos;


    // Constructeur AvanceLigne qui initialise l'attribut pos
    public AvanceLigne(Position p){
        this.pos = p;
    }

    // Méthode run qui est le Thread qui fait avancer la ligne brisée vers la gauche
    @Override
    public void run(){
        while(true){
            try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
            if(pos.getAvancement()<4) pos.avance();
        }
    }
}
