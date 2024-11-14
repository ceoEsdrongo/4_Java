import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String nomeFile = "libri.txt";
        PrintWriter pw;

        try {
            pw = new PrintWriter(nomeFile);

            // Inserimento dei libri, ogni libro su una nuova riga
            pw.print("Titolo:Il Principe;");
            pw.print("Autore:Niccolò Machiavelli;");
            pw.println("Categoria:Letteratura Italiana;");

            pw.print("Titolo:Sistemi e Reti2;");
            pw.print("Autore:Hoepli;");
            pw.println("Categoria:Sistemi e Reti;");

            pw.print("Titolo:Operazione Barbarossa;");
            pw.print("Autore:Hoepli;");
            pw.println("Categoria:Storia;");

            // Chiusura del file per salvare
            pw.close();

        } catch (IOException e) {
            System.out.println("Problemi in casa Ferrari: " + e);
        }
    }
}
