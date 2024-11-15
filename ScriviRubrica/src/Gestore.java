import java.io.*;
import java.util.Vector;

public class Gestore {
    private Vector<Contatto> rubrica;
    private static final String FILE_NAME = "rubrica.txt";

    public Gestore() {
        rubrica = caricaDaFile();
    }

    // Aggiungi un contatto e salva su file
    public void aggiungiContatto(Contatto c) {
        rubrica.add(c);
        salvaSuFile();
    }

    // Elimina un contatto e salva su file
    public boolean eliminaContatto(String cognome, String nome) {
        for (Contatto c : rubrica) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                rubrica.remove(c);
                salvaSuFile();
                return true;
            }
        }
        return false;
    }

    // Aggiorna il numero di un contatto e salva su file
    public boolean aggiornaNumero(String cognome, String nome, double nuovoNumero) {
        for (Contatto c : rubrica) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(nuovoNumero);
                salvaSuFile();
                return true;
            }
        }
        return false;
    }

    // Cerca il numero di un contatto
    public Double cercaNumero(String cognome, String nome) {
        for (Contatto c : rubrica) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                return c.getNumero();
            }
        }
        return null;
    }

    // Visualizza i contatti
    public void visualizzaRubrica() {
        if (rubrica.isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            for (Contatto c : rubrica) {
                System.out.println(c.toString());
            }
        }
    }

    // Salva la rubrica su file
    private void salvaSuFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            for (Contatto c : rubrica) {
                writer.write(c.getCognome() + ";" + c.getNome() + ";" + c.getNumero() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei contatti.");
        }
    }

    // Carica la rubrica da file
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
            System.out.println("Il file non esiste, verrà creata una nuova rubrica.");
        } catch (IOException e) {
            System.out.println("Errore durante il caricamento dei contatti.");
        }
        return rubrica;
    }
}
