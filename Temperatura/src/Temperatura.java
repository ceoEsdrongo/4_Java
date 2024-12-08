import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

public class Temperatura implements Serializable {

    private double valore;
    private Vector<Temperatura> misure;

    public Temperatura(Random rnd) {
        this.valore = -10 + (40 - (-10)) * rnd.nextDouble();
    }

    public Temperatura() {
        this.misure = new Vector<>();
    }

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public void aggiungiMisura(Random rnd) {
        Temperatura temp = new Temperatura(rnd);
        misure.add(temp);
    }

    public void MisureCasuali(Random rnd) {
        for (int i = 0; i < 100; i++) {
            aggiungiMisura(rnd);
        }
    }

    public double calcolaMedia() {
        double somma = 0;
        for (Temperatura temp : misure) {
            somma += temp.getValore();
        }
        return somma / misure.size();
    }

    public double calcolaDeviazioneStandard() {
        double media = calcolaMedia();
        double somma = 0;
        for (Temperatura temp : misure) {
            somma += Math.pow(temp.getValore() - media, 2);
        }
        return Math.sqrt(somma / misure.size());
    }

    public Vector<Temperatura> selezionaMisureCasuali(int percentuale, Random rnd) {
        int numMisure = (int) (misure.size() * (percentuale / 100.0));
        Vector<Temperatura> selezionate = new Vector<>();
        while (selezionate.size() < numMisure) {
            int indiceCasuale = rnd.nextInt(misure.size());
            if (!selezionate.contains(misure.get(indiceCasuale))) {
                selezionate.add(misure.get(indiceCasuale));
            }
        }
        return selezionate;
    }

    public double calcolaMediaSubset(Vector<Temperatura> subset) {
        double somma = 0;
        for (Temperatura temp : subset) {
            somma += temp.getValore();
        }
        return somma / subset.size();
    }

    public double calcolaDeviazioneStandardSubset(Vector<Temperatura> subset) {
        double media = calcolaMediaSubset(subset);
        double somma = 0;
        for (Temperatura temp : subset) {
            somma += Math.pow(temp.getValore() - media, 2);
        }
        return Math.sqrt(somma / subset.size());
    }
}
