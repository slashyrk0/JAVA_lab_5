//Odczytywanie i rozpoznawanie tokenu z pliku 
//za pomoc� metod klasy Scanner
//----------------------------------------------------------
package obsluga_plikow;

import java.util.*;
import java.io.*;

public class PlikiScanerStringB {

    final static InputStreamReader wejscie = new InputStreamReader(System.in);
    final static BufferedReader bufor = new BufferedReader(wejscie);
    static Scanner scaner = new Scanner(bufor);

    static public String weString() {
        return scaner.next();
    }

    static public void Zapiszplik() {
        String dane = "1";
        try {
            FileWriter plik = new FileWriter("plikScanerStringB.txt");
            try (BufferedWriter bufor1 = new BufferedWriter(plik)) {
                while (!dane.equals("k")) {
                    System.out.print("Podaj dane: ");
                    dane = weString();
                    if (!dane.equals("k")) {
                        bufor1.write(dane, 0, dane.length());
                    }
                }
                bufor1.close();
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku tekstowego" + e);
        }
    }

    static public void Odczytajplik() {
        String dane;
        try {
            FileReader plik = new FileReader("plikScanerStringB.txt");
            BufferedReader bufor1 = new BufferedReader(plik);
            try (Scanner scaner2 = new Scanner(bufor1)) {
                while (scaner2.hasNext()) {
                    dane = scaner2.next();
                    System.out.print(dane);
                }
                scaner2.close();
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Blad odczytu pliku tekstowego" + e);
        }
    }

    public static void main(String[] args) {
        Zapiszplik();
        Odczytajplik();
    }

}
