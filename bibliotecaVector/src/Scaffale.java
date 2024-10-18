/*Si vogliono memorizzare le informazioni dei libri della biblioteca dell'Euganeo riportando,
per ogni libro, il codice ISBN (codice univoco), il titolo, l’autore, l’argomento e il prezzo.
Realizzare la classe Libro con quanto richiesto.
Creare la classe Biblioteca con il nome della biblioteca e il numero max di libri presenti.
Sviluppare le funzionalità CRUD (controllare che i codici ISBN siano univoci, aggiungere i
controlli opportuni e try-catch,…) per risolvere i seguenti punti:
1. creare una biblioteca con un certo nome e un numero massimo di libri
2. inserire dei libri nella biblioteca, uno alla volta controllando l’univocità del codice
ISBN
3. visualizzare
a. tutta la biblioteca
b. visualizzare le informazioni di un libro dato un codice ISBN
c. visualizzare l'autore del libro di un certo titolo
d. visualizzare l’elenco dei libri che hanno un prezzo compreso tra un min e max
e. visualizzare l’elenco dei libri di un certo argomento
f. visualizzare il titolo dei libri che hanno il prezzo più alto
4. aggiornare le informazioni di un libro dato il suo ISBN
5. cancellare un libro dato il suo ISBN*/

import java.util.Vector;

public class Scaffale {
    private String nomeScaffale;
    private Vector<Libro> libri;
    private int contaLibri;
    private int maxLibri;

    // Costruttore
    public Scaffale(String nomeScaffale, int maxLibri) {
        this.nomeScaffale = nomeScaffale;
        this.maxLibri = maxLibri;
        this.libri = new Vector<Libro>(3, 1);
        this.contaLibri = 0;
    }

    // Inserimento di un libro nello scaffale
    public void inserisciLibro(Libro libro) {
        if (contaLibri < maxLibri) {
            // Controllo per ISBN univoco
            for (int i = 0; i < contaLibri; i++) {
                if (libri.get(i).getISBN().equals(libro.getISBN())) {
                    System.out.println("ISBN già presente. Impossibile aggiungere il libro.");
                    return;
                }
            }
            System.out.println("Libro aggiunto con successo.");
        } else {
            System.out.println("Scaffale pieno.");
        }
    }

    // Visualizza tutti i libri nello scaffale
    public void visualizzaScaffale() {
        if (contaLibri == 0) {
            System.out.println("Lo scaffale è vuoto.");
        } else {
            for (int i = 0; i < contaLibri; i++) {
                libri.get(i).visualizza();
            }
        }
    }

    // Visualizza un libro per ISBN
    public void visualizzaLibroPerISBN(String ISBN) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri.get(i).getISBN().equals(ISBN)) {
                libri.get(i).visualizza();
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Visualizza gli autori dei libri di un certo titolo
    public void visualizzaAutorePerTitolo(String titolo) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri.get(i).getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("Autore di " + titolo + ": " + libri.get(i).getAutore());
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Visualizza i libri con prezzo in un intervallo
    public void visualizzaLibriPerPrezzo(double min, double max) {
        boolean trovato = false;
        for (int i = 0; i < contaLibri; i++) {
            if (libri.get(i).getPrezzo() >= min && libri.get(i).getPrezzo() <= max) {
                libri.get(i).visualizza();
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato nel range di prezzo specificato.");
        }
    }

    // Visualizza i libri di un certo argomento
    public void visualizzaLibriPerArgomento(String argomento) {
        boolean trovato = false;
        for (int i = 0; i < contaLibri; i++) {
            if (libri.get(i).getArgomento().equalsIgnoreCase(argomento)) {
                libri.get(i).visualizza();
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun libro trovato per l'argomento specificato.");
        }
    }

    // Visualizza il titolo del libro con il prezzo più alto
    public void visualizzaTitoloPrezzoMassimo() {
        if (contaLibri == 0) {
            System.out.println("Lo scaffale è vuoto.");
            return;
        }
        Libro maxPrezzoLibro = libri.get(0);
        for (int i = 1; i < contaLibri; i++) {
            if (libri.get(i).getPrezzo() > maxPrezzoLibro.getPrezzo()) {
                maxPrezzoLibro = libri.get(i);
            }
        }
        System.out.println("Titolo del libro con il prezzo più alto: " + maxPrezzoLibro.getTitolo());
    }

    // Aggiorna le informazioni di un libro dato il suo ISBN
    public void aggiornaLibro(String ISBN, String nuovoTitolo, String nuovoAutore, String nuovoArgomento, double nuovoPrezzo) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri.get(i).getISBN().equals(ISBN)) {
                libri.get(i).setTitolo(nuovoTitolo);
                libri.get(i).setAutore(nuovoAutore);
                libri.get(i).setArgomento(nuovoArgomento);
                libri.get(i).setPrezzo(nuovoPrezzo);
                System.out.println("Libro aggiornato con successo.");
                return;
            }
        }
        System.out.println("Libro non trovato per aggiornamento.");
    }

    // Cancella un libro dato il suo ISBN
    public void cancellaLibro(String ISBN) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri.get(i).getISBN().equals(ISBN)) {
                libri.remove(i);
                System.out.println("Libro cancellato con successo.");
                return;
            }
        }
        System.out.println("Libro non trovato per la cancellazione.");
    }
}