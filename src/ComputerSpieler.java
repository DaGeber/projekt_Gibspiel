import java.util.Random;
import java.util.Scanner;

public class ComputerSpieler extends Spieler{

    public ComputerSpieler(String name) {
        super(name);
    }

    @Override
    public int steineSetzen() {
        int zufallZahl = (int)(Math.random()*10);
        System.out.println("Am Zug: Spieler " + getName());
        System.out.println("Ihre Wahl (1-10): " + zufallZahl);
        return zufallZahl;
    }
}
