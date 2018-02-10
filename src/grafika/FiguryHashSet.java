package grafika;

import figury.Kolo;
import figury.Kwadrat;
import figury.Punkt;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FiguryHashSet extends Figury {

    public void pojemnik() {
        figury = new ArrayList<>();
    }

    public boolean wyszukaj(Punkt p) {
        return figury.contains(p);
    }

    public boolean wyszukaj(int dane[]) {
        Punkt p;
        if (dane[0] == 0) {
            p = new Punkt(dane[1], dane[2]);
        } else {
            p = new Kwadrat(dane[1], dane[2], dane[3]);
        }
        return wyszukaj(p);
    }

    public void wypelnij() {
        for (int i = 0; i < N; i++) {
            figury.add(new Punkt(20 * (N+i), 10 * (N+i)));
            figury.add(new Kwadrat((i + 1) * 20, (i + 1) * 20, 20));
            figury.add(new Kolo((i + 1) , (i + 1) * 30, 20));
        }
    }
    public void init() {
        pojemnik();
        wypelnij();
        polozenie();
    }

    public void Zapis_do_pliku() {
        //
        // try with resources - Java 7.
        try (BufferedWriter bufor1 = new BufferedWriter(new FileWriter("Figury_text.txt"))) {

            for(int i=0; i<figury.size(); i++) {
                bufor1.write(figury.get(i).toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Odczytaj_plik() {
        String dane;
        //
        // try with resources - Java 7.
        try (BufferedReader bufor1 = new BufferedReader(new FileReader("Figury_text.txt"))){
            while ((dane = bufor1.readLine()) != null) {
                System.out.println(dane);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
