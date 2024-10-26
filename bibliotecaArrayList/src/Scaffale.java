import java.util.ArrayList;

public class Scaffale {
    private String nomeScaffale;
    private ArrayList<Libro> libri;

    // Costruttore
    public Scaffale(String nomeScaffale, int maxLibri) {
        this.nomeScaffale = nomeScaffale;
        this.libri = new ArrayList<>(maxLibri);
    }


    public void inserisciLibro(Libro libro) {

        for (Libro l : libri) {
            if (l.getISBN().equals(libro.getISBN())) {
                System.out.println("ISBN già presente. Impossibile aggiungere il libro.");
                return;
            }
        }
        libri.add(libro);
        System.out.println("Libro aggiunto con successo.");
    }

    // Visualizza tutti i libri nello scaffale
    public void visualizzaScaffale() {
        if (libri.isEmpty()) {
            System.out.println("Lo scaffale è vuoto.");
        } else {
            for (Libro libro : libri) {
                libro.visualizza();
            }
        }
    }

    public void visualizzaLibroPerISBN(String ISBN) {
        for (Libro libro : libri) {
            if (libro.getISBN().equals(ISBN)) {
                libro.visualizza();
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    public void visualizzaAutorePerTitolo(String titolo) {
        for (Libro libro : libri) {
            if (libro.getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("Autore di " + titolo + ": " + libro.getAutore());
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    public void visualizzaLibriPerPrezzo(double min, double max) {
        boolean trovato = false;
        for (Libro libro : libri) {
            if (libro.getPrezzo() >= min && libro.getPrezzo() <= max) {
                libro.visualizza();
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato nel range di prezzo specificato.");
        }
    }

    public void visualizzaLibriPerArgomento(String argomento) {
        boolean trovato = false;
        for (Libro libro : libri) {
            if (libro.getArgomento().equalsIgnoreCase(argomento)) {
                libro.visualizza();
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato per l'argomento specificato.");
        }
    }

    public void visualizzaTitoloPrezzoMassimo() {
        if (libri.isEmpty()) {
            System.out.println("Lo scaffale è vuoto.");
            return;
        }
        Libro maxPrezzoLibro = libri.get(0);
        for (Libro libro : libri) {
            if (libro.getPrezzo() > maxPrezzoLibro.getPrezzo()) {
                maxPrezzoLibro = libro;
            }
        }
        System.out.println("Titolo del libro con il prezzo più alto: " + maxPrezzoLibro.getTitolo());
    }

    public void aggiornaLibro(String ISBN, String nuovoTitolo, String nuovoAutore, String nuovoArgomento, double nuovoPrezzo) {
        for (Libro libro : libri) {
            if (libro.getISBN().equals(ISBN)) {
                libro.setTitolo(nuovoTitolo);
                libro.setAutore(nuovoAutore);
                libro.setArgomento(nuovoArgomento);
                libro.setPrezzo(nuovoPrezzo);
                System.out.println("Libro aggiornato con successo.");
                return;
            }
        }
        System.out.println("Libro non trovato per aggiornamento.");
    }

    public void cancellaLibro(String ISBN) {
        for (int i = 0; i < libri.size(); i++) {
            if (libri.get(i).getISBN().equals(ISBN)) {
                libri.remove(i);
                System.out.println("Libro cancellato con successo.");
                return;
            }
        }
        System.out.println("Libro non trovato per la cancellazione.");
    }
}
