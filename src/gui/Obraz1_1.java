package gui;

import grafika.FiguryHashSet;
import grafika.Figury_panel;
import javax.swing.JFrame;
public class Obraz1_1 {

    void rysunek_Swing() {
        JFrame ramka = new JFrame();
        Figury_panel panel = new Figury_panel();
        panel.init();
        ramka.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ramka.setSize(600, 400);
        ramka.setContentPane(panel);
        ramka.setVisible(true);
    }
    void rysunek_konsola() {
        FiguryHashSet kontroler = new FiguryHashSet();
        kontroler.init();
    }
    public static void main(String args[]) {
        Obraz1_1 obraz = new Obraz1_1();
        obraz.rysunek_konsola();
        obraz.rysunek_Swing();
    }
}

