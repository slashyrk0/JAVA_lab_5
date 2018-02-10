package figury;

import java.awt.*;

public class Kolo extends Punkt {
    public final int promien;

    public Kolo(int wspX, int wspY, int promien) {
        super(wspX, wspY);
        this.promien = promien;
    }

    public int getPromien() {
        return promien;
    }

    public double odleglosc() {
        return Math.sqrt(x * x + y * y);
    }

    // przyblizenie, czy lezy w obrebie kwadratu otaczajacego kolo
    public boolean lezy_na(int x_, int y_) {
        if (x + getPromien() >= x_
                && x <= x_
                && y + getPromien() >= y_
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
        int hash = 9;
        hash = 56 * hash + promien;
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
        final Kolo other = (Kolo) obj;
        if (this.promien != other.promien) {
            return false;
        }
        return this.compareTo(obj)==0;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Kolo{" + "promien=" + promien + '}' + " i dziedzicze od " + s;
    }

    @Override
    public void rysuj(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Color pedzel = new Color(85, 10, 155);
        g2D.setColor(pedzel);
        g2D.fillOval(x, y, promien, promien);
    }
}
