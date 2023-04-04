public class Spielbrett {
    private int aktuelleAnzahlSteine;

    public int getAktuelleAnzahlSteine() {
        return aktuelleAnzahlSteine;
    }

    public void startSpiel() {
        aktuelleAnzahlSteine = (int)(Math.random() * 30);
    }

    public boolean macheZug(int anzahlSteine) {
        if (anzahlSteine < 1 || anzahlSteine > 10)
            return false;

        if (aktuelleAnzahlSteine + anzahlSteine > 100)
            return false;

        aktuelleAnzahlSteine += anzahlSteine;
        return true;
    }

    public boolean hatGewonnen() {
        return (aktuelleAnzahlSteine == 100);
    }
}
