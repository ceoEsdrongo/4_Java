import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String nomeFile = "biblioteca.csv"; // CSV per i libri
    private String ISBN;
    private String titolo;
    private String autore;
    private String argomento;
    private double prezzo;

    // Costruttore vuoto
    public Libro() {
        this.ISBN = "";
        this.titolo = "";
        this.autore = "";
        this.argomento = "";
        this.prezzo = 0.0;
    }

    // Metodo per inserire i dati del libro
    public void inserimento() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci ISBN: ");
        this.ISBN = sc.nextLine();

        System.out.print("Inserisci il titolo: ");
        this.titolo = sc.nextLine();

        System.out.print("Inserisci l'autore: ");
        this.autore = sc.nextLine();

        System.out.print("Inserisci l'argomento: ");
        this.argomento = sc.nextLine();

        System.out.print("Inserisci il prezzo: ");
        this.prezzo = sc.nextDouble();
        sc.nextLine(); // Consuma la newline rimasta

        // Scrittura dei dati nel file CSV
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile, true))) {
            pw.println(ISBN + ";" + titolo + ";" + autore + ";" + argomento + ";" + prezzo);
            System.out.println("Libro aggiunto con successo!");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
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

    // Metodo toString per visualizzare il libro in modo leggibile
    @Override
    public String toString() {
        return "Libro{" + "ISBN='" + ISBN + '\'' + ", titolo='" + titolo + '\'' + ", autore='" + autore + '\'' + ", argomento='" + argomento + '\'' + ", prezzo=" + prezzo + '}';
    }

    // Metodo per visualizzare i dettagli del libro
    public void visualizza() {
        System.out.println(this.toString());
    }
}
