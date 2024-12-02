import java.io.IOException;
import java.io.RandomAccessFile;
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

    public void stampaMisure() {
        for (int i = 0; i < misure.size(); i++) {
            System.out.println("Misura " + (i + 1) + ": " + misure.get(i).getValore() + " °C");
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f °C", valore);
    }
    public void convertCsvToDat(String inputFile, String outputFile) {
        try {
            // Creazione di un RandomAccessFile per leggere il file CSV
            RandomAccessFile csvReader = new RandomAccessFile(inputFile, "r");
            // Creazione di un RandomAccessFile per scrivere nel file .dat
            RandomAccessFile datWriter = new RandomAccessFile(outputFile, "rw");

            String line;
            while ((line = csvReader.readLine()) != null) {
                // Si assume che il CSV abbia valori separati da virgola
                String[] values = line.split(",");

                // Scrittura dei valori nel file .dat
                for (String value : values) {
                    // Scrivere il valore nel file .dat
                    datWriter.writeBytes(value);  // Scrive il valore come stringa
                    datWriter.writeBytes(" ");    // Aggiunge uno spazio tra i valori
                }

                // Aggiunge un terminatore di linea alla fine di ogni riga
                datWriter.writeBytes("\n");
            }

            // Chiudiamo i flussi
            csvReader.close();
            datWriter.close();

            System.out.println("Conversione completata con successo!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
