/*Si abbia il file di testo in formato csv "MisureTemperature.csv" che memorizza un certo
numero di misurazioni di temperatura riportando in ogni riga di testo il numero della misura
(intero) e la misura (double).
Trasferire i dati del file di testo in un file ad accesso diretto “MisureTemperature.dat”.
Prendendo in considerazione il file ad accesso diretto, risolvere i seguenti punti:
1. determinare la media e la deviazione standard di tutte le misure
2. determinare la media e la deviazione standard prendendo in considerazione il 50%
delle misure totali scegliendole casualmente.
3. determinare la media e la deviazione standard prendendo in considerazione solo il
10% delle misure totali scegliendole casualmente
4. Considerazioni sui risultati…
guarda il testo
*/


import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Temperatura temperatura = new Temperatura();

        // Passo 1: Generare 100 misure casuali
        temperatura.MisureCasuali(rnd);

        // Passo 2: Calcolare media e deviazione standard di tutte le misure
        double mediaTotale = temperatura.calcolaMedia();
        double deviazioneTotale = temperatura.calcolaDeviazioneStandard();

        System.out.printf("Media di tutte le misure: %.2f °C%n", mediaTotale);
        System.out.printf("Deviazione standard di tutte le misure: %.2f °C%n", deviazioneTotale);

        // Passo 3: Calcolare media e deviazione standard su 50% delle misure casuali
        Vector<Temperatura> misure50 = temperatura.selezionaMisureCasuali(50, rnd);
        double media50 = temperatura.calcolaMediaSubset(misure50);
        double deviazione50 = temperatura.calcolaDeviazioneStandardSubset(misure50);

        System.out.printf("Media del 50%% delle misure: %.2f °C%n", media50);
        System.out.printf("Deviazione standard del 50%% delle misure: %.2f °C%n", deviazione50);

        // Passo 4: Calcolare media e deviazione standard su 10% delle misure casuali
        Vector<Temperatura> misure10 = temperatura.selezionaMisureCasuali(10, rnd);
        double media10 = temperatura.calcolaMediaSubset(misure10);
        double deviazione10 = temperatura.calcolaDeviazioneStandardSubset(misure10);

        System.out.printf("Media del 10%% delle misure: %.2f °C%n", media10);
        System.out.printf("Deviazione standard del 10%% delle misure: %.2f °C%n", deviazione10);

        // Considerazioni
        System.out.println("\nConsiderazioni:");
        System.out.println("Riducendo il campione, la media e la deviazione possono variare.");
        System.out.println("La deviazione standard tende a essere più bassa con campioni più piccoli.");
    }
}
