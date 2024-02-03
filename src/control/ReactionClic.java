package control;

import model.Position;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReactionClic extends MouseAdapter {
    private Position pos;

    //Constructeur qui initialise l'attribut pos par l'argument p
    public ReactionClic(Position p){
        this.pos = p;
    }

    //Méthode mouseClicked qui appelle la méthode jump de pos pour chaque clic de souris
    @Override
    public void mouseClicked(MouseEvent e){
        this.pos.jump();
    }
}
