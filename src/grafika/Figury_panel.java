package grafika;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Figury_panel extends JPanel implements ActionListener {
    protected JButton zapis = new JButton("Zapis do pliku tekstowego");
    protected JButton odczyt = new JButton("Odczyt z pliku tekstowego");
    protected JButton usun=new JButton("Usun figury");

    FiguryHashSet kontroler;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        kontroler.rysuj_figury(g);
    }

    public void init() {
        kontroler = new FiguryHashSet();
        kontroler.pojemnik();
        kontroler.wypelnij();
        zapis.addActionListener(this);
        odczyt.addActionListener(this);
        usun.addActionListener(this);
        add(zapis);
        add(odczyt);
        add(usun);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();
        if (zrodlo == zapis) {
            kontroler.Zapis_do_pliku();
        }
        else if (zrodlo == odczyt) {
            kontroler.Odczytaj_plik();
        }else if (zrodlo == usun) {
            kontroler.figury.clear();
        }
        requestFocus();
        repaint();
    }
}
