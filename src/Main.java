public class Main {
    public static void main(String[] args) {
        final int numPosti = 3;
        final int tempoMin = 1000;
        final int tempoMax = 5000;
        final int numeroAutoTotali = 10;

        Parcheggio parcheggio = new Parcheggio(numPosti);

        for (int i = 0; i < numeroAutoTotali; i++) {
            Auto auto = new Auto(parcheggio, tempoMin, tempoMax);
            auto.start();
            try {
                Thread.sleep(800); // simula arrivo progressivo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            parcheggio.controllaCoda();
            parcheggio.rimuoviAutoRandom();
        }
    }
}