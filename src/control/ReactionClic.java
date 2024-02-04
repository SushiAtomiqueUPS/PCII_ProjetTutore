package control;

import model.Position;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReactionClic extends MouseAdapter {

    // Attribut pos de type postition qui contient la position de l'ovale
    private Position pos;


    // Constructeur qui initialise l'attribut pos par l'argument p
    public ReactionClic(Position p){
        this.pos = p;
    }

    // Méthode mouseClicked qui appelle la méthode saut de pos à chaque clic de souris
    @Override
    public void mouseClicked(MouseEvent e){
        this.pos.saut();
    }
}
