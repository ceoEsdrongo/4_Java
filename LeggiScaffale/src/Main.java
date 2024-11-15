import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String nomeFile = "C:\\Users\\Angelo\\OneDrive\\Desktop\\informatica\\java4AI\\scriviScaffale\\biblioteca.txt"; // Nome del file

    public static void main(String[] args) {
        Scaffale euganeo = new Scaffale("Biblioteca Euganeo");

        // Carica i dati dal file nello scaffale
        caricaDatiDaFile(euganeo);

        // Visualizza i libri caricati
        System.out.println("\n--- Libri nella biblioteca ---");
        euganeo.visualizza();
    }

    public static void caricaDatiDaFile(Scaffale scaffale) {
        try {
            File file = new File(nomeFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] dettagli = linea.split(";");
                if (dettagli.length == 5) {
                    String isbn = dettagli[0];
                    String titolo = dettagli[1];
                    String autore = dettagli[2];
                    String argomento = dettagli[3];
                    double prezzo = Double.parseDouble(dettagli[4]);

                    // Crea un libro e lo aggiunge allo scaffale
                    Libro libro = new Libro(isbn, titolo, autore, argomento, prezzo);
                    scaffale.inserimento(libro);
                } else {
                    System.out.println("Formato non valido: " + linea);
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }
}
