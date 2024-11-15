public class Libro {
    private String ISBN, titolo, autore, argomento;
    private double prezzo;

    public Libro(String ISBN, String titolo, String autore, String argomento, double prezzo) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.argomento = argomento;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Titolo: " + titolo + ", Autore: " + autore + ", Argomento: " + argomento + ", Prezzo: " + prezzo;
    }

    // Getter
    public String getISBN() {
        return ISBN;
    }
}
