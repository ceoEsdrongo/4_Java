import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main2 {
    public static void main(String[] args) {
        String nomeFile = "rubrica.dat"; // Nome del file binario per i libri

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            System.out.println("--- Lettura dei contatti ---");

            // Continuare a leggere oggetti finché ci sono oggetti nel file
            while (true) {
                try {
                    Contatto c = (Contatto) ois.readObject();  // Legge un oggetto Contatto
                    System.out.println(c);  // Stampa l'oggetto Contatto
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