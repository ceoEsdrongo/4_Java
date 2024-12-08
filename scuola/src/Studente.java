import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/*Esercizio-2
In un file di testo 4AI.csv (‘;’ come separatore) sono memorizzate le informazioni degli
studenti della classe 4AI con cognome, nome e voto di informatica (intero).
Risolvere i seguenti punti:
1. leggere dal file i dati degli studenti e salvarli su un Vector o ArrayList
2. utilizzando il Vector o ArrayList precedentemente creato, salvare sul file
sufficienti.csv cognome e nome degli studenti con voto di informatica sufficiente*/
public class Studente {
    private String nome;
    private String cognome;
    private int voto;
    private Vector<Studente> stds = new Vector<>();
    private String aula="studenti.csv";

    // Costruttore con parametri
    public Studente(String nome, String cognome, int voto) {
        this.nome = nome;
        this.cognome = cognome;
        this.voto = voto;
    }

    // Costruttore vuoto per gestione nel main
    public Studente() {
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getVoto() {
        return voto;
    }

    // Metodo per inserire studenti
    public void anagrafica() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Inserisci il cognome dello studente:");
            String cognome = sc.nextLine();

            System.out.println("Inserisci il nome dello studente:");
            String nome = sc.nextLine();

            System.out.println("Inserisci il voto dello studente:");
            int voto = sc.nextInt();
            sc.nextLine();  // Pulisce il buffer

            // Crea un nuovo oggetto Studente e aggiungilo alla lista
            stds.add(new Studente(nome, cognome, voto));
        }
    }

    public void salvaStudenti() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sufficienti.csv", true))) {

            for (Studente s : stds) {
                if (s.getVoto() >= 6) {
                    String linea = s.getCognome() + " " + s.getNome() + " " + s.getVoto() + "; ";
                    writer.write(linea);
                }
            }

            writer.newLine();  // Aggiunge una nuova riga a fine scrittura
            System.out.println("File creato correttamente!");

        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }


}
