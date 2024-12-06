import java.io.*; // Importa le classi per la gestione dei file
import java.util.Scanner; // Importa la classe Scanner per leggere input da tastiera
import java.util.Vector; // Importa la classe Vector per memorizzare le temperature
/*In una stazione metereologica viene effettuata ogni giorno alle ore 12.00 la misura della
temperatura (double) dell’aria e salvata nel file temperature.csv (con separatore ';').
Scrivere un programma che permetta ogni giorno di leggere dall’input la temperatura
misurata e di inserirla nel file. Il programma deve poi visualizzare la media delle
temperature misurate.*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crea un oggetto Scanner per leggere l'input da tastiera
        Vector<Double> temperatures = new Vector<>(); // Crea un Vector per memorizzare le temperature
        String meteo = "temperature.csv"; // Nome del file in cui salvare le temperature

        // Ciclo per leggere 5 temperature dall'utente
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Inserisci la temperatura in gradi:"); // Chiede all'utente di inserire una temperatura
                Double temperatura = sc.nextDouble(); // Legge la temperatura come numero decimale (double)
                temperatures.add(temperatura); // Aggiunge la temperatura al Vector
            }

            // Scrittura delle temperature nel file temperature.csv
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(meteo, true))) {
                // Usa BufferedWriter per scrivere nel file, il parametro true permette di aggiungere al file senza sovrascrivere
                for (Double temp : temperatures) {
                    writer.write(temp + ";"); // Scrive ogni temperatura nel file separandole con un punto e virgola
                }
                writer.newLine(); // Dopo aver scritto tutte le temperature, va a capo nel file
            }

            // Lettura delle temperature dal file e calcolo della media
            BufferedReader reader = new BufferedReader(new FileReader(meteo)); // Apre il file per leggere
            String line; // Variabile per memorizzare le righe lette dal file
            double total = 0; // Variabile per sommare le temperature
            int count = 0; // Variabile per tenere traccia del numero di temperature lette

            // Ciclo per leggere ogni riga del file
            while ((line = reader.readLine()) != null) {
                // Per ogni riga, separa gli elementi con il punto e virgola
                String[] elements = line.split(";");
                for (String element : elements) {
                    try {
                        total += Double.parseDouble(element); // Converte la stringa in un numero double e lo somma
                        count++; // Aumenta il conteggio delle temperature
                    } catch (NumberFormatException e) {
                        // Se non si riesce a convertire l'elemento in un numero, ignora l'errore
                    }
                }
            }

            // Calcolo e visualizzazione della media delle temperature
            if (count > 0) { // Se ci sono temperature lette
                double average = total / count; // Calcola la media
                System.out.println("La media delle temperature è: " + average); // Mostra la media
            } else {
                System.out.println("Nessuna temperatura trovata nel file."); // Se non ci sono temperature, mostra un messaggio
            }

        } catch (IOException e) {
            // Se c'è un errore durante la lettura/scrittura dei file, stampa l'errore
            e.printStackTrace();
        } finally {
            sc.close(); // Chiude lo scanner per liberare risorse
        }
    }
}
