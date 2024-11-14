import java.io.*;
/**
 * Esempio di scrittura di un file di testo. File CSV
 * Ogni riga rappresenta un "prodotto" con
 * descrizione;peso;prezzo
 * separati con punto e virgola.
 *
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {

        String nomeFile = "NomeFile.txt";
        PrintWriter pw;

        try {
            pw=new PrintWriter(nomeFile);

            //Inseriamo nel file i prodotti
            //un prodotto per riga separati con punto e virgola
            pw.print("Spaghetti" + ";");
            pw.print("500" + ";");
            pw.println("0,95");

            pw.print("Pelati" + ";");
            pw.print("400" + ";");
            pw.println("1,25");

            pw.print("Pane" + ";");
            pw.print("700" + ";");
            pw.println("3,15");

            pw.print("Marmellata" + ";");
            pw.print("350" + ";");
            pw.println("2,70");

            //chiusura del file, NECESSARIA,
            //salva definitavamente sul disco
            pw.close();

        } catch (IOException e) {
            System.out.println("Eccezione" + e);
            //e.printStackTrace();
        }

    }

}