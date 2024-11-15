import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Libro {
    private String ISBN, titolo, autore, argomento;
    private double prezzo;
    private static final String nomeFile = "libri.txt";  // File per la scrittura dei libri
    private PrintWriter pw;

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

    // Getters e Setters
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

    // Metodo per inserire un nuovo libro, chiedendo i dati all'utente
    public void inserimento() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci ISBN: ");
        ISBN = sc.nextLine();

        System.out.print("Inserisci il titolo: ");
        titolo = sc.nextLine();

        System.out.print("Inserisci l'autore: ");
        autore = sc.nextLine();

        System.out.print("Inserisci l'argomento: ");
        argomento = sc.nextLine();

        System.out.print("Inserisci il prezzo: ");
        prezzo = sc.nextDouble();

        // Scrittura del libro nel file
        try {
            pw = new PrintWriter(new java.io.FileWriter(nomeFile, true));  // 'true' per appendere al file
            pw.println(ISBN + ";" + titolo + ";" + autore + ";" + argomento + ";" + prezzo);
            pw.close();
            System.out.println("Libro aggiunto con successo!");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN='" + ISBN + '\'' + ", titolo='" + titolo + '\'' + ", autore='" + autore + '\'' + ", argomento='" + argomento + '\'' + ", prezzo=" + prezzo + '}';
    }

    // Visualizza informazioni del libro
    public void visualizza() {
        System.out.println(this.toString());
    }
}
