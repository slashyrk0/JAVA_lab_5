//Strumien bajtowy niebuforowany - Plik binarny
//---------------------------------------------
package obsluga_plikow;

import java.io.*;
import java.util.*;

public class PlikiByteNB {

    static InputStreamReader wejscie = new InputStreamReader(System.in);
    static BufferedReader bufor = new BufferedReader(wejscie);

    static public byte weByte() {
        StringTokenizer zeton;
        try {
            zeton = new StringTokenizer(bufor.readLine());
            return Byte.parseByte(zeton.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO byte " + e);
            return 0;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu short " + e);
            return 0;
        }
    }

    static public void Zapiszplik() {
        int dane = 0;
        try {
            try (FileOutputStream plik = new FileOutputStream("plikByteNB.dat")) {
                while (dane != -1) {
                    System.out.print("Podaj dane: ");
                    dane = weByte();
                    if (dane != -1) {
                        plik.write(dane);
                    }
                }
                 plik.close();
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku bajtowego" + e);
        }
    }

    static public void Odczytajplik() {
        int dane;
        try {
            try (FileInputStream plik = new FileInputStream("plikByteNB.dat")) {
                dane = plik.read();
                while (dane != -1) {
                    System.out.print(dane);
                    dane = plik.read();
                }
                System.out.println("");
                plik.close();
            }
        } catch (IOException e) {
            System.out.println("Blad odczytu pliku bajtowego" + e);
        }
    }

    public static void main(String[] args) {
        Zapiszplik();
        Odczytajplik();
    }
}
