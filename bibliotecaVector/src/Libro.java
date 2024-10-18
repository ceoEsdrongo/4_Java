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