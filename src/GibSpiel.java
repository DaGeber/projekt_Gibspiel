import java.util.Random;
import java.util.Scanner;

public class GibSpiel {
    /*
    Ein Spiel für 2 Spieler
    Jeder Spieler kann 1-10 Elemente auf einem Spielbrett platzieren.
    selbst gewählt, mind eins, max 10 Elemente.
    Welcher Spieler das 100.Element hinlegt hat gewonnen.
    Das Spiel beginnt mit einer zufälligen Anzahl von Elementen (<30),
    die bereits auf dem Spielbrett liegen.

    Benutzen Sie das Konzept der Vererbung

    Notwendige Klassen:
        - Spieler
            - MenschSpieler
            - ComputerSpieler
        - Spielbrett
     */
    public static void main(String[] args) {
        // Erster Setup für zwei menschliche Spieler
        Scanner eingabe = new Scanner(System.in);


        System.out.println("1. Zweispieler");
        System.out.println("2. VS. PC");
        System.out.println("3. PC vs. PC");
        System.out.println("0. Beenden");
        int auswahl = eingabe.nextInt();
        switch (auswahl) {
            case 0:
                System.out.println("Spiel wurde beendet");
                break;
            case 1:
                System.out.print("Name des Spieler 1: ");
                Spieler spieler1 = new MenschSpieler(eingabe.next());
                System.out.print("Name des Spieler 2: ");
                Spieler spieler2 = new MenschSpieler(eingabe.next());
                randomBeginn(spieler1, spieler2);
                break;
            case 2:
                System.out.print("Name des Spieler 1: ");
                Spieler spieler3 = new MenschSpieler(eingabe.next());
                Spieler computer = new ComputerSpieler("ComputerSpieler 1");
                randomBeginn(spieler3, computer);
                break;
            case 3:
                Spieler computer1 = new ComputerSpieler("ComputerSpieler 1");
                Spieler computer2 = new ComputerSpieler("ComputerSpieler 2");
                randomBeginn(computer1,computer2);
                break;
        }
    }

    private static void randomBeginn(Spieler spieler1, Spieler spieler2) {
        Random radom = new Random();
        int zufall = radom.nextInt(1,10);
        if (zufall % 2 == 0) {
            spielBeginnen(spieler1,spieler2);
        }else spielBeginnen(spieler2,spieler1);

    }
    private static void spielBeginnen(Spieler spieler1, Spieler spieler2) {
        Spielbrett spielbrett = new Spielbrett();
        spielbrett.startSpiel();

        while (true) {
            ausgabeSteineAktuell(spielbrett);
            zug(spieler1, spielbrett);
            if (gewonnen(spieler1, spielbrett)) break;
            ausgabeSteineAktuell(spielbrett);
            zug(spieler2,spielbrett);
            if (gewonnen(spieler2, spielbrett)) break;
        }
    }

    private static void ausgabeSteineAktuell(Spielbrett spielbrett) {
        System.out.print("Steine auf dem Brett: ");
        System.out.println(spielbrett.getAktuelleAnzahlSteine());
    }

    private static void zug(Spieler spieler, Spielbrett spielbrett) {
        int anzahlSteine;
        do {
            if (spieler instanceof ComputerSpieler) {
                ((ComputerSpieler) spieler).setAktuelleAnzahlElemente(spielbrett.getAktuelleAnzahlSteine());
            }
            anzahlSteine = spieler.steineSetzen();
        } while (!spielbrett.macheZug( anzahlSteine ));
    }

    private static boolean gewonnen(Spieler spieler, Spielbrett spielbrett) {
        if (spielbrett.hatGewonnen()) {
            System.out.println(spieler.getName() + " hat gewonnen");
            return true;
        }
        return false;
    }
}
