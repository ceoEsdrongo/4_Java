-------------Main //le cose migliori alla fine



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
    private final int cont = 3;
    private String ISBN;
    private String titolo;
    private String argomento;
    private double prezzo;


    //costruttore
    public Libro() {
        ISBN = "";
        titolo = "";
        argomento = "";
        prezzo = 0;


    }

    public Libro(String ISBN, String titotlo, String argomento, double prezzo) {
        this.ISBN = ISBN;
        this.titolo = titotlo;
        this.argomento = argomento;
        this.prezzo = prezzo;

    }
    //getters setters

    public String getTitotlo() {
        return titolo;
    }

    public void setTitotlo(String titotlo) {
        this.titolo = titotlo;
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

    public String getISBN() {

        return ISBN;
    }

    public void setISBN(String ISBN) {
        if (ISBN.length() == 3) this.ISBN = ISBN;
    }

    public void inserisci() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Inserisci l'ISBN del libro");
            ISBN = sc.nextLine();
        } while (cont != 3);
        System.out.println("inserisci il titolo del libro");
        titolo = sc.nextLine();
        System.out.println("inserisci l'argomento del libro");
        argomento = sc.nextLine();
        System.out.println("inserisci il prezzo");
        prezzo = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN='" + ISBN + '\'' + ", titolo='" + titolo + '\'' + ", argomento='" + argomento + '\'' + ", prezzo=" + prezzo + ", cont=" + cont + '}';
    }
    public void visualizza(){
        System.out.println(this.toString());
    }
}



---------------Scaffale //in fase di costruzione
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

import java.util.Arrays;

public class Scaffale {
    private String nomeScaffale;
    private Libro[] libri;
    private int contaLibri;
    private int maxlibri;
    private Libro book;

    //costruttore
    public Scaffale() {
        this.nomeScaffale = "Esdrongo";
        this.contaLibri = 0;
        this.maxlibri = 0;
    }

    public Scaffale(String nomeScaffale, int contaLibri) {
        this.nomeScaffale = nomeScaffale;
        this.contaLibri = 0;
        libri = new Libro[maxlibri];
    }

    public void inserisci() {
        if (contaLibri < maxlibri) {
            book = new Libro();
            book.inserisci();
            libri[contaLibri] = book;
            contaLibri++;
        } else {
            System.out.println("scaffale pieno");
        }
    }
    

    @Override
    public String toString() {
        return "Scaffale{" + "nomeScaffale='" + nomeScaffale + '\'' + ", libri=" + Arrays.toString(libri) + ", contaLibri=" + contaLibri + ", maxlibri=" + maxlibri + ", book=" + book + '}';
    }
}

