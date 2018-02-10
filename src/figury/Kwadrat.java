package figury;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Kwadrat extends Punkt {
    protected int dlugosc;

    public Kwadrat(int wspX, int wspY, int dlugosc_) {
        super(wspX, wspY);
        dlugosc = dlugosc_;
    }

    public int getDl() {
        return dlugosc;
    }

    public double odleglosc() {
        return Math.sqrt(x * x + y * y);
    }

    public boolean lezy_na(int x_, int y_) {
        if (x + getDl() >= x_
                && x <= x_
                && y + getDl() >= y_
                && y <= y_) {
            return true;
        }
        return false;
    }

    @Override
    public double odleglosc(Punkt p) {
        return odleglosc() + super.odleglosc(p);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.dlugosc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true;
        }
        if (obj == null) { return false;
        }
        if (getClass() != obj.getClass()) { return false;
        }
        final Kwadrat other = (Kwadrat) obj;
        if (this.dlugosc != other.dlugosc) {
            return false;
        }
        return this.compareTo(obj)==0;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Kwadrat{" + "dlugosc=" + dlugosc + '}' + " i dziedzicze od " + s;
    }

    @Override
    public void rysuj(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Color pedzel = new Color(0, 255, 0);
        g2D.setColor(pedzel);
        g2D.fillRect(x, y, dlugosc, dlugosc);
    }
}
