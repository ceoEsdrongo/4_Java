-------------Main
public class Main {
    public static void main(String[] args) {
        // Creazione di uno scaffale con un massimo di 5 libri
        Scaffale scaffale = new Scaffale("Scaffale di Letteratura Italiana e Storia", 5);

        // Creazione di alcuni libri con temi di letteratura italiana e storia della WWII
        Libro libro1 = new Libro("9788804608146", "La Divina Commedia", "Dante Alighieri", "Letteratura Italiana", 12.50);
        Libro libro2 = new Libro("9788858400078", "Se questo è un uomo", "Primo Levi", "Storia WWII", 12.50);
        Libro libro3 = new Libro("9788804414324", "Il Principe", "Niccolò Machiavelli", "Letteratura Italiana", 10.00);
        Libro libro4 = new Libro("9788842072245", "La guerra di mondi", "H.G. Wells", "Storia WWII", 11.00);

        // Inserimento dei libri nello scaffale
        scaffale.inserisciLibro(libro1);
        scaffale.inserisciLibro(libro2);
        scaffale.inserisciLibro(libro3);
        scaffale.inserisciLibro(libro4);

        // Visualizzazione di tutti i libri nello scaffale
        System.out.println("Contenuto dello scaffale:");
        scaffale.visualizzaScaffale();

        // Visualizzazione di un libro per ISBN
        System.out.println("Visualizzazione del libro con ISBN 9788804414324:");
        scaffale.visualizzaLibroPerISBN("9788804414324");
    }
}



--------------Libro //finito
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


import java.util.Scanner;
public class Libro {
    private String ISBN;
    private String titolo;
    private String autore;
    private String argomento;
    private double prezzo;

    // costruttore senza parametri
    public Libro() {
        ISBN = "";
        titolo = "";
        autore = "";
        argomento = "";
        prezzo = 0;
    }

    // costruttore con parametri
    public Libro(String ISBN, String titolo, String autore, String argomento, double prezzo) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.argomento = argomento;
        this.prezzo = prezzo;
    }

    // getters e setters
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // metodo per inserire un nuovo libro
    public void inserisci() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'ISBN del libro:");
        ISBN = sc.nextLine();

        System.out.println("Inserisci il titolo del libro:");
        titolo = sc.nextLine();

        System.out.println("Inserisci l'autore del libro:");
        autore = sc.nextLine();

        System.out.println("Inserisci l'argomento del libro:");
        argomento = sc.nextLine();

        System.out.println("Inserisci il prezzo del libro:");
        prezzo = sc.nextDouble();
        sc.nextLine(); // consuma la newline residua
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Titolo: " + titolo + ", Autore: " + autore + ", Argomento: " + argomento + ", Prezzo: " + prezzo;
    }
    public void visualizza(){
        System.out.println(toString());
    }
}
/*in entrambe le classi devi mettere l'inserimento e il visualizza in scaffale richiama toString e metti un sout
per svuotare il buffer sennò sta incallato li
 */




---------------Scaffale 
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

public class Scaffale {
    private String nomeScaffale;
    private Libro[] libri;
    private int contaLibri;
    private int maxLibri;

    // Costruttore
    public Scaffale(String nomeScaffale, int maxLibri) {
        this.nomeScaffale = nomeScaffale;
        this.maxLibri = maxLibri;
        this.libri = new Libro[maxLibri];
        this.contaLibri = 0;
    }

    // Inserimento di un libro nello scaffale
    public void inserisciLibro(Libro libro) {
        if (contaLibri < maxLibri) {
            // Controllo per ISBN univoco
            for (int i = 0; i < contaLibri; i++) {
                if (libri[i].getISBN().equals(libro.getISBN())) {
                    System.out.println("ISBN già presente. Impossibile aggiungere il libro.");
                    return;
                }
            }
            libri[contaLibri] = libro;
            contaLibri++;
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
                libri[i].visualizza();
            }
        }
    }

    // Visualizza un libro per ISBN
    public void visualizzaLibroPerISBN(String ISBN) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri[i].getISBN().equals(ISBN)) {
                libri[i].visualizza();
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Visualizza gli autori dei libri di un certo titolo
    public void visualizzaAutorePerTitolo(String titolo) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri[i].getTitolo().equalsIgnoreCase(titolo)) {
                System.out.println("Autore di " + titolo + ": " + libri[i].getAutore());
                return;
            }
        }
        System.out.println("Libro non trovato.");
    }

    // Visualizza i libri con prezzo in un intervallo
    public void visualizzaLibriPerPrezzo(double min, double max) {
        boolean trovato = false;
        for (int i = 0; i < contaLibri; i++) {
            if (libri[i].getPrezzo() >= min && libri[i].getPrezzo() <= max) {
                libri[i].visualizza();
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
            if (libri[i].getArgomento().equalsIgnoreCase(argomento)) {
                libri[i].visualizza();
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
        Libro maxPrezzoLibro = libri[0];
        for (int i = 1; i < contaLibri; i++) {
            if (libri[i].getPrezzo() > maxPrezzoLibro.getPrezzo()) {
                maxPrezzoLibro = libri[i];
            }
        }
        System.out.println("Titolo del libro con il prezzo più alto: " + maxPrezzoLibro.getTitolo());
    }

    // Aggiorna le informazioni di un libro dato il suo ISBN
    public void aggiornaLibro(String ISBN, String nuovoTitolo, String nuovoAutore, String nuovoArgomento, double nuovoPrezzo) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri[i].getISBN().equals(ISBN)) {
                libri[i].setTitolo(nuovoTitolo);
                libri[i].setAutore(nuovoAutore);
                libri[i].setArgomento(nuovoArgomento);
                libri[i].setPrezzo(nuovoPrezzo);
                System.out.println("Libro aggiornato con successo.");
                return;
            }
        }
        System.out.println("Libro non trovato per aggiornamento.");
    }

    // Cancella un libro dato il suo ISBN
    public void cancellaLibro(String ISBN) {
        for (int i = 0; i < contaLibri; i++) {
            if (libri[i].getISBN().equals(ISBN)) {
                // Sposta gli altri libri per riempire il vuoto
                for (int j = i; j < contaLibri - 1; j++) {
                    libri[j] = libri[j + 1];
                }
                libri[contaLibri - 1] = null; // Rimuove l'ultimo libro
                contaLibri--;
                System.out.println("Libro cancellato con successo.");
                return;
            }
        }
        System.out.println("Libro non trovato per la cancellazione.");
    }
}
/*equals è quando metti qualcosa che sai di non poter sbagliare come l'isbn li sono tutti numeri
* l'ignore case invece è meglio usarlo sul titolo argomentazioni... perchè se scrivi storia Storia STORIA te lo
* troverà SEMPRE l'equals da solo ti da errore se non scrivi essattamente come è statato impostato a quanto pare
* spiegarmelo l'anno scorso faceva schifo e sbagliavo in ricerca autore a volte zio pera */
