//zapis za pomoc� writeInt i odczyt za pomoc� readInt - z klawiatury s� podawane 4-bajtowe warto�ci
//-------------------------------------------------------------------------------------------------
package obsluga_plikow;

import java.io.*;
import java.util.*;

public class PlikiIntegerBData {

    static InputStreamReader wejscie = new InputStreamReader(System.in);
    static BufferedReader bufor = new BufferedReader(wejscie);

    static public int weInt() {
        StringTokenizer zeton;
        try {
            zeton = new StringTokenizer(bufor.readLine());
            return Integer.parseInt(zeton.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO int " + e);
            return 0;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu int " + e);
            return 0;
        }
    }

    static public void Zapiszplik() {
        int dane = 0;
        try {
            FileOutputStream plik = new FileOutputStream("plikIntegerBData.dat");
            BufferedOutputStream bufor1 = new BufferedOutputStream(plik);
            try (DataOutputStream dana = new DataOutputStream(bufor1)) {
                while (dane != -1) {
                    System.out.print("Podaj dane: ");
                    dane = weInt(); //odczyt warto�ci 4-bajtowej
                    if (dane != -1) {
                        dana.writeInt(dane);
                    }
                }  //zapis do pliku 4 bajtow
                dana.close();
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku bajtowego" + e);
        }
    }

    static public void Odczytajplik() {
        int dane = 0;
        try {
            FileInputStream plik = new FileInputStream("plikIntegerBData.dat");
            BufferedInputStream bufor = new BufferedInputStream(plik);
            DataInputStream dana = new DataInputStream(bufor);
            try {
                while (true) {
                    dane = dana.readInt();
                    System.out.print(dane);
                } //odczyt z pliku 4 bajt�w
            } catch (EOFException eof) {
                bufor.close();
            }      //zamkniecie bufora przez obsluge wyjatku od czytania poza plikiem 
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Blad odczytu pliku bajtowego" + e);
        }
    }

    public static void main(String[] args) {
        Zapiszplik();
        Odczytajplik();
    }
}
