import java.util.*;
import java.util.concurrent.*;

class Auto extends Thread {
    private static int contatore = 0;
    private final String nome;
    private final Parcheggio parcheggio;
    private final int tempoMin;
    private final int tempoMax;

    public Auto(Parcheggio parcheggio, int tempoMin, int tempoMax) {
        this.nome = "Auto-" + (++contatore);
        this.parcheggio = parcheggio;
        this.tempoMin = tempoMin;
        this.tempoMax = tempoMax;
    }

    public String getNome() {
        return nome;
    }

    public void parcheggia() throws InterruptedException {
        int tempoSosta = tempoMin + new Random().nextInt(tempoMax - tempoMin + 1);
        Thread.sleep(tempoSosta);
    }

    public void run() {
        try {
            parcheggio.entra(this);
        } catch (InterruptedException e) {
            System.out.println(nome + " interrotta mentre cercava posto.");
        }
    }
}