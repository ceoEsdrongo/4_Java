import java.io.*;
import java.util.Vector;

public class Gestore {
    private Vector<Contatto> rubrica;
    private static final String FILE_NAME = "C:\\Users\\Angelo\\OneDrive\\Desktop\\informatica\\java4AI\\ScriviContatto1\\rubrica.txt";

    public Gestore() {
        rubrica = caricaDaFile();
    }

    // Metodo per caricare la rubrica dal file
    private Vector<Contatto> caricaDaFile() {
        Vector<Contatto> rubrica = new Vector<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] dati = linea.split(";");
                if (dati.length == 3) {
                    Contatto c = new Contatto();
                    c.setCognome(dati[0]);
                    c.setNome(dati[1]);
                    c.setNumero(Double.parseDouble(dati[2]));
                    rubrica.add(c);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Il file non esiste o è vuoto.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento dei contatti.");
        }
        return rubrica;
    }

    // Metodo per visualizzare i contatti caricati
    public void visualizzaRubrica() {
        if (rubrica.isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            for (Contatto c : rubrica) {
                System.out.println(c.toString());
            }
        }
    }
}
