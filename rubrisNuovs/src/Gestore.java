import java.io.*;
import java.util.Vector;

public class Gestore implements Serializable {
    private static final String nomeFile = "rubrica.dat";
    private Vector<Contatto> rubrica;

    // Costruttore
    public Gestore() {
        rubrica = new Vector<>();
        caricaDaFile(); // Carica i contatti salvati (se esistono)
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

    private void salvaSuFile() {
        try (FileOutputStream fos = new FileOutputStream(nomeFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Contatto r : rubrica) {
                oos.writeObject(r);
            }
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio su file: " + e.getMessage());
        }
    }

    private void caricaDaFile() {
        try (FileInputStream fis = new FileInputStream(nomeFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                Contatto rubs = (Contatto) ois.readObject();
                rubrica.add(rubs);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante la lettura dal file: " + e.getMessage());
        }
    }
}
