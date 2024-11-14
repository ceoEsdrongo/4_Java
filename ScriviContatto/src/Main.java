/**/
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String nomeFile = "contatti.txt";
        PrintWriter pw;

        try {
            pw = new PrintWriter(nomeFile);

            // Inserimento dei libri, ogni libro su una nuova riga
            pw.print("Nome:Leonardo;");
            pw.print("Cognome:Raise;");
            pw.println("Numero:3315000000;");

            pw.print("Nome:Marcello;");
            pw.print("Cognome:Plate;");
            pw.println("Numero:0011000001;");

            pw.print("Nome:Mohamed;");
            pw.print("Cognome:xXMomyXx;");
            pw.println("Numero:6589412357;");

            // Chiusura del file per salvare
            pw.close();

        } catch (IOException e) {
            System.out.println("Problemi in casa RedBull: " + e);
        }
    }
}
