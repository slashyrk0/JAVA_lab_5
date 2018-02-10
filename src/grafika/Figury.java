package grafika;

import figury.Kwadrat;
import figury.Punkt;
import java.awt.Graphics;
import java.util.ArrayList;
public class Figury {
    protected int N = 3;
    public ArrayList<Punkt> figury;
    protected Punkt biezacy;

    public Punkt getBiezacy() {
        return biezacy;
    }

    public void polozenie() {
        for (Punkt figura : figury) {
            boolean p = figura instanceof Kwadrat;
            System.out.println(
                    p + ", ze jestem kwadratem, bo jestem " + figura.toString()
                            + ", X=" + figura.getX()
                            + ", Y=" + figura.getY()
                            + ", odleglosc=" + figura.odleglosc(figura));
        }
    }

    public boolean Clicked(int x_, int y_) {
        for (Punkt figura : figury) {
            if(figura.lezy_na(x_, y_)) {
                biezacy = figura;
                return true; }
        }
        return false;
    }


    public void rysuj_figury(Graphics g) {
        for (Punkt figura : figury) {
            figura.rysuj(g);
        }
    }

    public boolean przesun(int x, int y, int dl, int szer) {
        if (biezacy != null) {
            biezacy.przesun(x, y, dl, szer);
            return true; }
        return false;
    }
}
