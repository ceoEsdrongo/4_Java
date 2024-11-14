import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String nomeFile = "C:\\Users\\Angelo\\OneDrive\\Desktop\\informatica\\java4AI\\fileTesto2\\NomeFile.txt";

        try {
            FileInputStream fin = new FileInputStream(nomeFile);
            Scanner in = new Scanner(fin);

            // Finché ci sono prodotti da leggere
            while (in.hasNextLine()) {
                // Legge un prodotto
                String linea = in.nextLine();

                // Divide gli elementi con metodo split(...)
                String elementi[] = linea.split(";");

                // Verifica se ci sono almeno 3 elementi
                if (elementi.length >= 3) {
                    String descrizione = elementi[0];
                    String peso = elementi[1];
                    String prezzo = elementi[2];

                    System.out.print("descrizione=" + descrizione + " ");
                    System.out.print("peso=" + peso + " ");
                    System.out.print("prezzo=" + prezzo + " ");
                    System.out.println();
                } else {
                    System.out.println("Riga non valida (mancano dati): " + linea);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
