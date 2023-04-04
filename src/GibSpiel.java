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
        System.out.print("Name des Spieler 1: ");
        Spieler spieler1 = new MenschSpieler(eingabe.next());

        System.out.print("Name des Spieler 2: ");
        Spieler spieler2 = new ComputerSpieler(eingabe.next());

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
