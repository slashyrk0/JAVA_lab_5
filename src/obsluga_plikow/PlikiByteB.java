//Strumien bajtowy buforowany - Plik binarny
//------------------------------------------
package obsluga_plikow;

import java.io.*;
import java.util.*;

public class PlikiByteB {

    final static InputStreamReader wejscie = new InputStreamReader(System.in);
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
            FileOutputStream plik = new FileOutputStream("plikByteB.dat");
            try (BufferedOutputStream bufor1 = new BufferedOutputStream(plik)) {
                while (dane != -1) {
                    System.out.print("Podaj dane: ");
                    dane = weByte();
                    if (dane != -1) {
                        bufor1.write(dane);
                    }
                }
                bufor1.close();
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku bajtowego" + e);
        }
    }

    static public void Odczytajplik() {
        int dane;
        try {
            FileInputStream plik = new FileInputStream("plikByteB.dat");
            try (BufferedInputStream bufor1 = new BufferedInputStream(plik)) {
                dane = plik.read();
                while (dane != -1) {
                    System.out.print(dane);
                    dane = bufor1.read();
                }
                System.out.println("");
                 bufor1.close();
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
