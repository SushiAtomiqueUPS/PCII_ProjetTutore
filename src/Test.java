import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        /* Une fenêtre avec pour titre "Test" */
        JFrame fenetre = new javax.swing.JFrame("Test");
        /* Un bouton "coucou" qui écrit "coucou" dans la console chaque fois qu'on clique dessus" */
        JButton bouton = new javax.swing.JButton("coucou");
        bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("coucou");
            }
        });
        /* On ajoute le bouton à la fenêtre */
        fenetre.add(bouton);
        /* On ferme la fenêtre quand on clique sur la croix */
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        /* On adapte la taille de la fenêtre au contenu */
        fenetre.pack();
        /* On rend la fenêtre visible */
        fenetre.setVisible(true);

        System.out.println("Hello World!");
    }
}
