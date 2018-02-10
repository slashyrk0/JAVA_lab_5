package figury;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class Punkt implements Comparable {
    protected int x, y;

    public Punkt(int wspX, int wspY) {
        x = wspX;
        y = wspY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean lezy_na(int x_, int y_) {
        return x == x_ && y == y_;
    }

    @Override
    public int compareTo(Object o) {
        Punkt p = (Punkt) o;
        if ((x == p.x) && (y == p.y)) {
            return 0;
        } else if ((x < p.x) && (y < p.y)) {
            return -1;
        }
        return 1;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.x;
        hash = 17 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return this.compareTo(obj)==0;
    }

    public double odleglosc(Punkt p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }

    @Override
    public String toString() {
        return "Punkt{" + "x=" + x + ", y=" + y + '}';
    }

    public int getDl() {
        return 5;
    }

    public void przesun(int dx, int dy, int a, int b) {
        x += dx;
        y += dy;
        if (x > a || x < 1) {
            x = 5;
        }
        if (y > b || y < 1) {
            y = 2;
        }
    }
    public void rysuj(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        Color pedzel = new Color(255, 0, 0);
        g2D.setColor(pedzel);
        g2D.fillOval(x, y,5, 5);
    }
}
