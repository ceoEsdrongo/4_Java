import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Scaffale {
    private ArrayList<Libro> libri;

    public Scaffale() {
        libri = new ArrayList<>();
        caricaLibriDaFile();  // Carica i libri al momento della creazione dell'oggetto
    }

    // Metodo per caricare i libri dal file
    private void caricaLibriDaFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Studente\\IdeaProjects\\scriviScaffale\\libri.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String ISBN = parts[0];
                    String titolo = parts[1];
                    String autore = parts[2];
                    String argomento = parts[3];
                    double prezzo = Double.parseDouble(parts[4]);

                    Libro libro = new Libro(ISBN, titolo, autore, argomento, prezzo);
                    libri.add(libro);
                }
            }
        } catch (IOException e) {
            System.out.println("Errore nel leggere il file: " + e.getMessage());
        }
    }

    // Metodo per visualizzare tutti i libri
    public void visualizzaLibri() {
        if (libri.isEmpty()) {
            System.out.println("Nessun libro trovato.");
        } else {
            for (Libro libro : libri) {
                System.out.println(libro);
            }
        }
    }
}
