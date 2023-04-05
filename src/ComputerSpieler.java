import java.util.Random;

public class ComputerSpieler extends Spieler{
    private int aktuelleAnzahlElemente;
    public ComputerSpieler(String name) {
        super(name);
    }
    Random zufall = new Random();
    public void setAktuelleAnzahlElemente(int aktuelleAnzahlElemente) {
        this.aktuelleAnzahlElemente = aktuelleAnzahlElemente;
    }

    @Override
    public int steineSetzen() {
        int zufallsZahl = zufall.nextInt(1,10);;
        System.out.println("Am Zug: " + getName());
        if (aktuelleAnzahlElemente < 88 && aktuelleAnzahlElemente > 77)
        System.out.println("Ihre Wahl (1-10): " + zufallsZahl);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return zufallsZahl;
    }

}
