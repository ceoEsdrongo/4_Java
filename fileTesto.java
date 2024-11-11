import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeFile = "fileTesto.txt";

        try {
           PrintWriter pw=new PrintWriter(nomeFile);
            pw.print("momy"+ ";");
            pw.print("bazaj"+ ";");
            pw.print("targa"+ ";");

            pw.print("pelati"+ ";");
            pw.print("spiller"+ ";");
            pw.print("malengo"+ ";");

            pw.print("pane"+ ";");
            pw.print("700"+ ";");
            pw.print("3.15"+ ";");

            pw.close();
            }
        catch (FileNotFoundException e){
            System.out.println("eccezione "+e);
            e.printStackTrace();
        }
        
        
    }
}
