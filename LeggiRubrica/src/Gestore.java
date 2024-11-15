import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Gestore {
    private ArrayList<Contatto> rubrica;

    // Costruttore
    public Gestore() {
        rubrica = new ArrayList<>();
        caricaContattiDaFile();  // Carica i contatti dal file all'inizio
    }

    // Metodo per caricare i contatti dal file
    private void caricaContattiDaFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Studente\\IdeaProjects\\ScriviRubrica\\rubrica.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  // Supponiamo che i contatti siano separati da virgole
                if (parts.length == 3) {
                    String cognome = parts[0];
                    String nome = parts[1];
                    double numero = Double.parseDouble(parts[2]);

                    Contatto contatto = new Contatto(cognome, nome, numero);
                    rubrica.add(contatto);
                }
            }
        } catch (IOException e) {
            System.out.println("Errore nel leggere il file: " + e.getMessage());
        }
    }

    // Metodo per aggiungere un contatto
    public void aggiungiContatto(Contatto c) {
        rubrica.add(c);  // Aggiungi il contatto alla rubrica
        // Puoi anche mantenere l'ordine alfabetico, come hai fatto prima
        rubrica.sort((c1, c2) -> c1.getCognome().compareToIgnoreCase(c2.getCognome()));
    }

    // Metodo per eliminare un contatto
    public boolean eliminaContatto(String cognome, String nome) {
        return rubrica.removeIf(c -> c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome));
    }

    // Metodo per aggiornare il numero di un contatto
    public boolean aggiornaNumero(String cognome, String nome, double nuovoNumero) {
        for (Contatto c : rubrica) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(nuovoNumero);
                return true;
            }
        }
        return false;
    }

    // Metodo per cercare un contatto
    public Double cercaNumero(String cognome, String nome) {
        for (Contatto c : rubrica) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                return c.getNumero();
            }
        }
        return null;
    }

    // Metodo per visualizzare contatti che iniziano con una lettera
    public void visualizzaPerLettera(char lettera) {
        for (Contatto c : rubrica) {
            if (c.getCognome().toUpperCase().charAt(0) == Character.toUpperCase(lettera)) {
                c.visualizza();
            }
        }
    }

    // Metodo per visualizzare tutta la rubrica
    public void visualizzaRubrica() {
        if (rubrica.isEmpty()) {
            System.out.println("Nessun contatto trovato.");
        } else {
            for (Contatto c : rubrica) {
                c.visualizza();
            }
        }
    }
}
