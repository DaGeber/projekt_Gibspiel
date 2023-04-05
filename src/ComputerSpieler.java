import java.util.Random;

public class ComputerSpieler extends Spieler {
    private int aktuelleAnzahlElemente;

    public ComputerSpieler(String name) {
        super(name);
    }

    //  Random zufall = new Random();
    public void setAktuelleAnzahlElemente(int aktuelleAnzahlElemente) {
        this.aktuelleAnzahlElemente = aktuelleAnzahlElemente;
    }

    @Override
    public int steineSetzen() {
        int legeZahl;
        System.out.println("Am Zug: " + getName());
        System.out.print("Ihre Wahl (1-10): ");
        if (aktuelleAnzahlElemente == 87) {
            System.out.println("2");
            legeZahl = 2;
        } else if (aktuelleAnzahlElemente % 10 == 7 && aktuelleAnzahlElemente < 90) {
            System.out.println("10");
            legeZahl = 10;
        } else if (aktuelleAnzahlElemente > 90) {
            legeZahl = 100 - aktuelleAnzahlElemente;
            System.out.println(legeZahl);
        } else {
            int rest = aktuelleAnzahlElemente % 10;
            if (rest < 7) {
                legeZahl = 7 - rest;
                System.out.println(legeZahl);
            } else {
                legeZahl = 17 - rest;
                System.out.println(legeZahl);
            }
        }
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return legeZahl;
    }

}
