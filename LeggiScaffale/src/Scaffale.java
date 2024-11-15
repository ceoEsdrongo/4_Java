import java.util.Vector;

public class Scaffale {
    private String nome;
    private Vector<Libro> targa;

    public Scaffale(String nome) {
        this.nome = nome;
        targa = new Vector<>();
    }

    public void inserimento(Libro l) {
        for (Libro book : targa) {
            if (book.toString().equals(l.toString())) {
                System.out.println("Libro già presente.");
                return;
            }
        }
        targa.add(l);
    }

    public void visualizza() {
        if (targa.isEmpty()) {
            System.out.println("Nessun libro presente nella biblioteca.");
        } else {
            for (Libro l : targa) {
                l.visualizza();
            }
        }
    }
}
