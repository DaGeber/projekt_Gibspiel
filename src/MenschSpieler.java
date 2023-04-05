import java.util.Scanner;

public class MenschSpieler extends Spieler {

    public MenschSpieler(String name) {
        super(name);
    }

    @Override
    public int steineSetzen() {
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Am Zug: Spieler " + getName());
        System.out.print("Ihre Wahl (1-10): ");
        return eingabe.nextInt();
    }
}
