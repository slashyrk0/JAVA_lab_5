//zapis za pomoc� writeInt i odczyt za pomoc� readInt - z klawiatury s� podawane 1-bajtowe warto�ci
//-------------------------------------------------------------------------------------------------
package obsluga_plikow;

import java.io.*;
import java.util.*;

public class PlikiByteBData {

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
            FileOutputStream plik = new FileOutputStream("plikByteBData.dat");
            BufferedOutputStream bufor1 = new BufferedOutputStream(plik);
            try (DataOutputStream dana = new DataOutputStream(bufor1)) {
                while (dane != -1) {
                    System.out.print("Podaj dane: ");
                    dane = weByte(); //odczyt warto�ci 1-bajtowej
                    if (dane != -1) {
                        dana.writeInt(dane);
                    }
                }
                dana.close();//zapis do pliku 4 bajtow po konwersji
            }
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku bajtowego" + e);
        }
    }

    static public void Odczytajplik() {
        int dane;
        try {
            FileInputStream plik = new FileInputStream("plikByteBData.dat");
            BufferedInputStream bufor1 = new BufferedInputStream(plik);
            DataInputStream dana = new DataInputStream(bufor1);
            try {
                while (true) {
                    dane = dana.readInt();
                    System.out.print(dane);
                }//odczyt z pliku 4 bajt�w
            } catch (EOFException eof) {
                dana.close();
            } //zamkniecie bufora przez obsluge wyjatku od czytania poza plikiem
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
