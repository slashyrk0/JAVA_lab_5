//Strumien tekstowy buforowany - Plik tekstowy
//--------------------------------------------
package obsluga_plikow;

import java.io.*;

public class PlikiStringB {
  static final InputStreamReader wejscie = new InputStreamReader(System.in);
  static  BufferedReader bufor = new BufferedReader(wejscie);
     
    static public String weString() {
        try {
            return bufor.readLine();
        } catch (IOException e) {
            System.err.println("Blad IO String");
            return "";
        }
    }

    static public void Zapiszplik() {
        String dane = "1";
        try {
            FileWriter plik = new FileWriter("plikStringB.txt");
            try (BufferedWriter bufor1 = new BufferedWriter(plik)) {
                while (!dane.equals("")) {
                    System.out.print("Podaj dane: ");
                    dane = weString();
                    if (!dane.equals("")) {
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
            FileReader plik = new FileReader("plikStringB.txt");
            try (BufferedReader bufor1 = new BufferedReader(plik)) {
                dane = bufor1.readLine();
                while (dane != null) {
                    System.out.print(dane);
                    dane = bufor1.readLine();
                }
                bufor1.close();
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
