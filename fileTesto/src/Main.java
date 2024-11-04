import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String nomeFile = "NomeFile.txt";
        try {
            //(NB)
            //fw gestisce il test su disco
            //true ->append
            FileWriter fw = new FileWriter(nomeFile, true);

            //pw permette di scrivere stringhe ed altro conprint
            PrintWriter pw = new PrintWriter(fw);
            System.out.println("bazaj era il mio compagno di banco preferito (mi manchi fragolino estremista di destra)");
            pw.println(12);
            pw.println("ciao targa");
            pw.println(546);
            pw.close();
        } catch (IOException e){
            System.out.println("eccezione"+ e);
            //e.printStackTrace();
        }
    }
}