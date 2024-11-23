import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main2 {
    public static void main(String[] args) {
        String nomeFile = "biblioteca.dat"; // Nome del file binario per i libri

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            System.out.println("--- Lettura dei Libri dal File Binario ---");

            // Continuare a leggere oggetti finché ci sono oggetti nel file
            while (true) {
                try {
                    Libro libro = (Libro) ois.readObject();  // Legge un oggetto Libro
                    System.out.println(libro);  // Stampa l'oggetto Libro
                } catch (IOException | ClassNotFoundException e) {
                    // Se non ci sono più oggetti o errore di lettura, usciamo dal ciclo
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Errore durante la lettura dal file binario: " + e.getMessage());
        }
    }
}
