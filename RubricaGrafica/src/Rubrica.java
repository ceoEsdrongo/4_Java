import java.io.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Rubrica implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector<Contatto> rubrica;
    private final String nomeFile = "Rubrica.dat";

    public Rubrica() {
        rubrica = new Vector<>();
        leggiRubrica(); // Carica i contatti all'avvio
    }

    public void aggiungiContatto(Contatto c) {
        rubrica.add(c);
        salvaRubrica();
    }

    public void cancella() {
        String nome = JOptionPane.showInputDialog("Inserisci il nome del contatto da eliminare:");
        String cognome = JOptionPane.showInputDialog("Inserisci il cognome del contatto da eliminare:");
        boolean trovato = false;

        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getNome().equalsIgnoreCase(nome) && rubrica.get(i).getCognome().equalsIgnoreCase(cognome)) {
                rubrica.remove(i);
                trovato = true;
                salvaRubrica();
                JOptionPane.showMessageDialog(null, "Contatto eliminato con successo.");
                break;
            }
        }

        if (!trovato) {
            JOptionPane.showMessageDialog(null, "Contatto non trovato.");
        }
    }

    public String ricerca() {
        String nome = JOptionPane.showInputDialog("Inserisci il nome del contatto da cercare:");
        String cognome = JOptionPane.showInputDialog("Inserisci il cognome del contatto da cercare:");
        for (Contatto c : rubrica) {
            if (c.getNome().equalsIgnoreCase(nome) && c.getCognome().equalsIgnoreCase(cognome)) {
                return c.toString();
            }
        }
        return "Contatto non trovato.";
    }

    public String visualizzaRubrica() {
        if (rubrica.isEmpty()) {
            return "Rubrica vuota.";
        }
        StringBuilder sb = new StringBuilder();
        for (Contatto c : rubrica) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public void salvaRubrica() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            oos.writeObject(rubrica);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore durante il salvataggio: " + e.getMessage());
        }
    }

    public void leggiRubrica() {
        File file = new File(nomeFile);
        if (!file.exists()) {
            return; // Se il file non esiste, esci senza errore
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))) {
            Object obj = ois.readObject();
            if (obj instanceof Vector) {
                rubrica = (Vector<Contatto>) obj; // Sovrascrive la lista con i contatti caricati
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Errore durante la lettura del file: " + e.getMessage());
        }
    }
}
