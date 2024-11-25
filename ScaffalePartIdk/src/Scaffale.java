import java.io.*;
import java.util.Vector;

public class Scaffale implements Serializable {
    private String nome;
    private Vector<Libro> targa;
    private static final String nomeFile = "biblioteca.dat";  // File per salvare la biblioteca

    public Scaffale(String nome) {
        this.nome = nome;
        this.targa = new Vector<>();
        caricaDaFile(); // Carica la biblioteca dal file all'avvio
    }

    // Inserimento di un libro nella lista
    public void inserimento(Libro l) {
        for (Libro book : targa) {
            if (book.getISBN().equals(l.getISBN())) {
                System.out.println("Libro già presente.");
                return;
            }
        }
        targa.add(l);
        salvaSuFile();
    }

    // Visualizza tutti i libri
    public void visualizza() {
        if (targa.isEmpty()) {
            System.out.println("Nessun libro presente nella biblioteca.");
        } else {
            for (Libro l : targa) {
                System.out.println(l);
            }
        }
    }

    // Visualizza un libro dato l'ISBN
    public void visualizzaISBN(String isbn) {
        for (Libro l : targa) {
            if (l.getISBN().equals(isbn)) {
                System.out.println(l);
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " non trovato.");
    }

    // Visualizza autore dato il titolo
    public void visualizzaAutore(String titolo) {
        for (Libro l : targa) {
            if (l.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("L'autore del libro \"" + titolo + "\" è: " + l.getAutore());
                return;
            }
        }
        System.out.println("Libro con titolo \"" + titolo + "\" non trovato.");
    }

    // Visualizza libri con prezzo compreso tra min e max
    public void visualizzaRange(double min, double max) {
        boolean trovato = false;
        for (Libro l : targa) {
            if (l.getPrezzo() >= min && l.getPrezzo() <= max) {
                System.out.println(l);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato nell'intervallo di prezzo.");
        }
    }

    // Visualizza libri per argomento
    public void argomento(String argomento) {
        boolean trovato = false;
        for (Libro l : targa) {
            if (l.getArgomento().equalsIgnoreCase(argomento)) {
                System.out.println(l);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato per l'argomento: " + argomento);
        }
    }

    // Visualizza il titolo del libro con il prezzo più alto
    public void prezzoMax() {
        if (targa.isEmpty()) {
            System.out.println("Nessun libro disponibile.");
            return;
        }

        double maxPrezzo = 0;
        String libroMaxPrezzo = "";
        for (Libro l : targa) {
            if (l.getPrezzo() > maxPrezzo) {
                maxPrezzo = l.getPrezzo();
                libroMaxPrezzo = l.getTitolo();
            }
        }

        System.out.println("Il libro con il prezzo più alto è: " + libroMaxPrezzo + " (Prezzo: " + maxPrezzo + ")");
    }

    // Cancella un libro tramite ISBN
    public void cancellaLibro(String isbn) {
        for (int i = 0; i < targa.size(); i++) {
            if (targa.get(i).getISBN().equals(isbn)) {
                targa.remove(i);
                System.out.println("Libro con ISBN " + isbn + " cancellato.");
                salvaSuFile();
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " non trovato.");
    }

    // Aggiorna un libro tramite ISBN
    public void aggiornaLibro(String isbn) {
        for (Libro l : targa) {
            if (l.getISBN().equals(isbn)) {
                System.out.println("Inserisci le nuove informazioni per il libro con ISBN " + isbn + ":");
                l.inserimento(); // Assumiamo che il metodo inserimento permetta di aggiornare i dati
                salvaSuFile();
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " non trovato.");
    }

    // Metodo per salvare la lista dei libri su file
    private void salvaSuFile() {
        try (FileOutputStream fos = new FileOutputStream(nomeFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Libro libro : targa) {
                oos.writeObject(libro);
            }
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio su file: " + e.getMessage());
        }
    }

    // Metodo per caricare i libri dal file
    private void caricaDaFile() {
        try (FileInputStream fis = new FileInputStream(nomeFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                Libro libro = (Libro) ois.readObject();
                targa.add(libro);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante la lettura dal file: " + e.getMessage());
        }
    }
}
