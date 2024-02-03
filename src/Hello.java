import javax.swing.*;
import java.awt.*;

/** Hello World dans un JFrame */
public class Hello {
    /** La méthode principale crée une fenêtre avec un Jlabel "Hello World!" **/
    public static void main(String [] args) {
        JFrame f = new JFrame("Test Windows");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel za = new JPanel();
        za.setPreferredSize(new Dimension(200,200));
        f.add(new JLabel("Hello World!"));
        f.add(za);

        f.pack();
        f.setVisible(true);

    }
}
