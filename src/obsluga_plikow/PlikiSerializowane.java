package obsluga_plikow;

import java.io.*;
import java.util.*;

class Wiadomosc implements Serializable {

    String dane;
    Date data;

    static String weString() {
        InputStreamReader wejscie = new InputStreamReader(System.in);
        BufferedReader bufor = new BufferedReader(wejscie);
        System.out.print("Podaj wiadomosc: ");
        try {
            return bufor.readLine();
        } catch (IOException e) {
            System.err.println("Blad IO String");
            return "";
        }
    }

    public void zapiszWiadomosc(Date d) {
        data = d;
        System.out.println(data);
        dane = weString();
    }

    public void odczytajWiadomosc() {
        System.out.println(data);
        System.out.println(dane);
    }

}

public class PlikiSerializowane {

    public static void Zapiszobiektydopliku() {
        Date d = new Date();
        Wiadomosc wiadomosc = new Wiadomosc();
        wiadomosc.zapiszWiadomosc(d);

        try {
            FileOutputStream plikobiektow = new FileOutputStream("Wiadomosc.obj");
            ObjectOutputStream strumienobiektow;
            strumienobiektow = new ObjectOutputStream(plikobiektow);
            strumienobiektow.writeObject(wiadomosc);
            wiadomosc.odczytajWiadomosc();
            d.setTime(1);   //zmiana daty w drugim obiekcie typu Wiadomosc
            strumienobiektow.writeObject(wiadomosc);
            System.out.println("Obiekt wiadomosc zostal zapisany do pliku");
            wiadomosc.odczytajWiadomosc();
            strumienobiektow.close();
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku obiektowego" + e);
        }

    }

    public static void Odczytajobiektyzpliku() {
        Wiadomosc wiadomosc;
        Wiadomosc wiadomosc1;
            try {
            FileInputStream plikobiektow = new FileInputStream("Wiadomosc.obj");
            ObjectInputStream strumienobiektow = new ObjectInputStream(plikobiektow);
            {
                wiadomosc = (Wiadomosc) strumienobiektow.readObject();
                System.out.println("Obiekt wiadomosc zostal odczytany z pliku");
                if (wiadomosc != null) {
                    wiadomosc.odczytajWiadomosc();
                }
                wiadomosc1 = (Wiadomosc) strumienobiektow.readObject();
                System.out.println("Obiekt wiadomosc zostal odczytany z pliku");
                if (wiadomosc1 != null) {
                    wiadomosc1.odczytajWiadomosc(); //zmieniona data nie została zapisana do strumienia
                }
                strumienobiektow.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Blad odczytu pliku obiektowego" + e);
        }
    }

    public static void main(String[] args) {
        Zapiszobiektydopliku();
        Odczytajobiektyzpliku();
    }
}
