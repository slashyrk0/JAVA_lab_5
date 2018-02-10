/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacje_we_wy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Zofia
 */
public class Operacje_we_wy {

    String menu=
              "1. We typu char\n"
            + "2. WE typu boolean\n"
            + "3. We typu String\n"
            + "4. We typu byte\n"
            + "5. We typu short\n"
            + "6. We typu int\n"
            + "7. We typu long\n"
            + "8. We typu float\n"
            + "9. We typu double\n"
            + "k - koniec programu\n"
            + "Podaj numer wejścia: ";

    //wejscie - pobranie ciągu znaków standardowego wejścia
    InputStreamReader wejscie = new InputStreamReader(System.in);

    //bufor - klasa odczytuje wejsciowy strumien znakowy ze strumienia
    //o nazwie wejscie i przechowuje w buforze
    BufferedReader bufor = new BufferedReader(wejscie);

    //klasa do analizy skladniowej jednostek leksykalnych tzw. leksemow
    //(tokens) pobieranych metodą nextToken()
    StringTokenizer bon;
    Scanner scaner = new Scanner(System.in);

    boolean weBoolean() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Boolean.parseBoolean(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO Boolean " + e);
            return false;
        }
    }
    
     char weChar() {
        try {
            String s = bufor.readLine();
            return s.charAt(0);
        } catch (IOException e) {
            System.err.println("Blad IO char " + e);
            return 0;
        }
    }

    char weScaner() {
        String s = scaner.next();
        return s.charAt(0);
    }

    String weString() {
        try {
            return bufor.readLine();
        } catch (IOException e) {
            System.err.println("Blad IO String");
            return "";
        }
    }

    byte weByte() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Byte.parseByte(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO byte " + e);
            return 0;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu byte " + e);
            return 0;
        }
    }

    short weShort() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Short.parseShort(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO short: " + e);
            return 0;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu short " + e);
            return 0;
        }
    }

    int weInt() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Integer.parseInt(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO int " + e);
            return 0;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu int " + e);
            return 0;
        }
    }

    long weLong() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Long.parseLong(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO " + e);
            return 0L;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu long " + e);
            return 0L;
        }
    }

    float weFloat() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Float.parseFloat(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO float " + e);
            return 0.0F;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu float " + e);
            return 0.0F;
        }
    }

    double weDouble() {
        try {
            bon = new StringTokenizer(bufor.readLine());
            return Double.parseDouble(bon.nextToken());
        } catch (IOException e) {
            System.err.println("Blad IO double " + e);
            return 0.0;
        } catch (NumberFormatException e) {
            System.err.println("Blad formatu double " + e);
            return 0;
        }
    }

    public void wybor_we() {
        char ktory;
        do {
            System.out.print(menu);
            ktory = weScaner();
            switch (ktory) {
                  case ('1'):
                    System.out.print("Podaj char: ");
                    System.out.println(weChar());
                    break;
                case ('2'):
                    System.out.print("Podaj boolean: ");
                    System.out.println(weBoolean());
                    break;
                case ('3'):
                    System.out.print("Podaj String: ");
                    System.out.println(weString());
                    break;
                case ('4'):
                    System.out.print("Podaj byte: ");
                    System.out.println(weByte());
                    break;
                case ('5'):
                    System.out.print("Podaj short: ");
                    System.out.println(weInt());
                    break;
                case ('6'):
                    System.out.print("Podaj int: ");
                    System.out.println(weShort());
                    break;
                case ('7'):
                    System.out.print("Podaj long: ");
                    System.out.println(weLong());
                    break;
                case ('8'):
                    System.out.print("Podaj float: ");
                    System.out.println(weFloat());
                    break;
                case ('9'):
                    System.out.print("Podaj double: ");
                    System.out.println(weDouble());
                    break;
                case ('k'):
                    System.exit(0);
                default:
                    System.out.println("Zla opcja");
            }
        } while (true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Operacje_we_wy konsola = new Operacje_we_wy();
        konsola.wybor_we();
    }

}
