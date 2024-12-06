import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/*In un file di testo 4AI.csv (‘;’ come separatore) sono memorizzate le informazioni degli
studenti della classe 4AI con cognome, nome e voto di informatica (intero).
Risolvere i seguenti punti:
1. leggere dal file i dati degli studenti e salvarli su un Vector o ArrayList
2. utilizzando il Vector o ArrayList precedentemente creato, salvare sul file
sufficienti.csv cognome e nome degli studenti con voto di informatica sufficiente*/
public class Main {
    public static void main(String[] args) {
        String classe = "4AI";
        Scanner sc = new Scanner(System.in);
        Vector<String> stds = new Vector<>();
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("inserisci il nome dello studente");
                String nome = sc.nextLine();
                stds.add(nome);
                System.out.println("inserisci il cognome dello studente");
                String cognome = sc.nextLine();
                stds.add(cognome);
                System.out.println("inserisci il voto dello studente");
                String voto = sc.nextLine();
                stds.add(voto);
                
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(classe, true))) {
                for (String aula : stds) {
                    writer.write(aula+";");
                }
                writer.newLine();
                
            } catch (IOException e) {
                System.out.println("exception"+e);
            }
        }finally {
            sc.close();
        }

    }
}
