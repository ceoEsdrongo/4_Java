import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeFile = "C:\\Users\\Angelo\\OneDrive\\Desktop\\informatica\\java4AI\\ScriviContatto\\contatti.txt";

        try {
            FileInputStream fin = new FileInputStream(nomeFile);
            Scanner in = new Scanner(fin);

            while (in.hasNextLine()) {
                String line = in.nextLine();

                // Divide la riga in sezioni separate da ";"
                String elementi[] = line.split(";");

                // Verifica che ci siano almeno tre elementi per ogni libro
                if (elementi.length >= 3) {
                    String nome = elementi[0];
                    String cognome = elementi[1];
                    String numero = elementi[2];

                    // Stampa le informazioni per ogni libro
                    System.out.println(nome);
                    System.out.println(cognome);
                    System.out.println(numero);
                    System.out.println();
                } else {
                    System.out.println("Riga non valida: " + line);
                }
            }

            // Chiude il file alla fine della lettura
            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + e.getMessage());
        }
    }
}