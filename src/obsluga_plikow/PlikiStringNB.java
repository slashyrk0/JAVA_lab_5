//Strumien tekstowy niebuforowany - Plik tekstowy
//-----------------------------------------------
package obsluga_plikow;

import java.io.*;

public class PlikiStringNB {

    final static InputStreamReader wejscie = new InputStreamReader(System.in);
    static BufferedReader bufor = new BufferedReader(wejscie);

    static public String weString() //metoda pobiera z klawiatury �a�cuchy
    {
        try {
            return bufor.readLine();
        } catch (IOException e) {
            System.err.println("Blad IO String");
            return "";
        }
    }

    static public void Zapiszplik() //metoda zapisuje plik
    {
        String dane = "1";
        try {
            try (FileWriter plik = new FileWriter("plikStringNB.txt")) {
                while (!dane.equals("")) {
                    System.out.print("Podaj dane: ");
                    dane = weString();
                    if (!dane.equals("")) {
                        plik.write(dane, 0, dane.length());
                    }
                }
                plik.close();
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku tekstowego" + e);
        }
    }

    static public void Odczytajplik() //metoda odczytuje plik
    {
        int dane = 0;
        try {
            try (FileReader plik = new FileReader("plikStringNB.txt")) {
                dane = plik.read();
                while (dane != -1) {
                    System.out.print((char) dane);
                    dane = plik.read();
                }
                plik.close();
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Blad odczytu pliku tekstowego" + e);
        }
    }

    public static void main(String[] args) {
        Zapiszplik(); 			//metody typu static
        Odczytajplik();
    }
}
