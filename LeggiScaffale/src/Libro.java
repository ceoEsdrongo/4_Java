public class Libro {
    private String ISBN, titolo, autore, argomento;
    private double prezzo;

    public Libro() {}

    public Libro(String ISBN, String titolo, String autore, String argomento, double prezzo) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.autore = autore;
        this.argomento = argomento;
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Libro{ISBN='" + ISBN + "', titolo='" + titolo + "', autore='" + autore + "', argomento='" + argomento + "', prezzo=" + prezzo + "}";
    }

    public void visualizza() {
        System.out.println(this);
    }
}
