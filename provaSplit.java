import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String nomeFile = "provaSplit.txt";
        PrintWriter pw;
        String linea;
        try {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                linea = in.nextLine();
                String elementi[] = linea.split(";");
                String descrizione = elementi[0];
                String peso = elementi[1];
                String prezzo = elementi[2];
                System.out.println("descrizione " + descrizione);
                System.out.println("peso " + peso);
                System.out.println("prezzo " + prezzo);
            }
        } catch (Exception e) {
            System.out.println("errore generico");
        }

    }
}
