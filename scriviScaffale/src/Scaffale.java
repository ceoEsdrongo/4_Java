import java.util.Vector;

public class Scaffale {
    private String nome;
    private Vector<Libro> targa;

    public Scaffale(String nome) {
        this.nome = nome;
        targa = new Vector<Libro>();
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
    }
    // Classe Scaffale
    public void visualizzaAutore(String titolo) {
        for (Libro l : targa) {
            if (l.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("L'autore del libro \"" + titolo + "\" è: " + l.getAutore());
                return;
            }
        }
        System.out.println("Libro con titolo \"" + titolo + "\" non trovato.");
    }


    // Visualizza tutti i libri
    public void visualizza() {
        if (targa.isEmpty()) {
            System.out.println("Nessun libro presente nella biblioteca.");
        } else {
            for (Libro l : targa) {
                l.visualizza();
            }
        }
    }

    // Visualizza un libro dato l'ISBN
    public void visualizzaISBN(String isbn) {
        for (Libro l : targa) {
            if (l.getISBN().equals(isbn)) {
                l.visualizza();
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " non trovato.");
    }

    // Visualizza libri con un prezzo nell'intervallo
    public void visualizzaRange(double min, double max) {
        boolean trovato = false;
        for (Libro l : targa) {
            if (l.getPrezzo() >= min && l.getPrezzo() <= max) {
                l.visualizza();
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
                l.visualizza();
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
                l.inserimento();
                return;
            }
        }
        System.out.println("Libro con ISBN " + isbn + " non trovato.");
    }
}