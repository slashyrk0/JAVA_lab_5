/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prezentacja_operacji_plikowych;

import java.util.Scanner;
import obsluga_plikow.PlikiByteNB;
import obsluga_plikow.PlikiByteB;
import obsluga_plikow.PlikiByteBData;
import obsluga_plikow.PlikiIntegerBData;
import obsluga_plikow.PlikiScanerStringB;
import obsluga_plikow.PlikiSerializowane;
import obsluga_plikow.PlikiStringNB;
import obsluga_plikow.PlikiStringB;

/**
 *
 * @author Zofia
 */
public class PLiki_danych {

    String menu
            = "1. Pliki typu Byte Stream bez burowowania\n"
            + "2. Pliki typu Byte Stream buforowane\n"
            + "3. Pliki typu Data Stream (type byte) buforowane\n"
            + "4. Pliki typu Data Stream (type int) buforowane\n"
            + "5. Pliki typu Character Stream niebuforowane\n"
            + "6. Pliki typu Character Stream buforowane\n"
            + "7. Pliki typu Character Stream buforowane - odczyt z wykorzystanie obiektu typu Scanner\n"
            + "8. Pliki serializowane"
            + "k - koniec programu\n"
            + "Podaj numer wejścia: ";
    Scanner scaner = new Scanner(System.in);

    char weChar() {
        String s = scaner.next();
        return s.charAt(0);
    }

    public void wybor_we() {
        char ktory = 0;
        do {
            System.out.print(menu);
            ktory = weChar();
            switch (ktory) {
                case ('1'):
                    PlikiByteNB.Zapiszplik();
                    PlikiByteNB.Odczytajplik();
                    break;
                case ('2'):
                    PlikiByteB.Zapiszplik();
                    PlikiByteB.Odczytajplik();
                    break;
                case ('3'):
                    PlikiByteBData.Zapiszplik();
                    PlikiByteBData.Odczytajplik();
                    break;
                case ('4'):
                    PlikiIntegerBData.Zapiszplik();
                    PlikiIntegerBData.Odczytajplik();
                    break;
                case ('5'):
                    PlikiStringNB.Zapiszplik();
                    PlikiStringNB.Odczytajplik();
                    break;
                case ('6'):
                    PlikiStringB.Zapiszplik();
                    PlikiStringB.Odczytajplik();
                    break;
                case ('7'):
                    PlikiScanerStringB.Zapiszplik();
                    PlikiScanerStringB.Odczytajplik();
                    break;
                case ('8'):
                    PlikiSerializowane.Zapiszobiektydopliku();
                    PlikiSerializowane.Odczytajobiektyzpliku();
                    break;
                case ('k'):
                    System.exit(0);
                default:
                    System.out.println("Zla opcja");
            }
        } while (true);
    }

    public static void main(String[] args) {

        PLiki_danych konsola = new PLiki_danych();
        konsola.wybor_we();
    }

}
