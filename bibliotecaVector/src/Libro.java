import java.util.Scanner;

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
public class Libro {
    private String ISBN, titolo, autore, argomento;
    private double prezzo;

    public Libro() {
        ISBN = "";
        titolo = "";
        autore = "";
        argomento = "";
        prezzo = 0;
    }

    public Libro(String ISBN, String titolo, String autore, String argomento, Double prezzo) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.argomento = argomento;
        this.prezzo = prezzo;
    }
    //getters e setters

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void inserimento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci l'ISBN del libro");
        ISBN = sc.nextLine();
        System.out.println("inserisci il titolo ");
        titolo = sc.nextLine();
        System.out.println("inserisci l'autore");
        autore = sc.nextLine();
        System.out.println("inserisci l'argomento");
        argomento = sc.nextLine();
        System.out.println("inserisci il prezzo del libro");
        prezzo = sc.nextDouble();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN='" + ISBN + '\'' + ", titolo='" + titolo + '\'' + ", autore='" + autore + '\'' + ", argomento='" + argomento + '\'' + ", prezzo=" + prezzo + '}';
    }

    public void visualizza() {
        System.out.println(this.toString());
    }
}
