import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class Contatto implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String nomeFile = "rubrica.dat";  // File per la scrittura dei contatti
    private String cognome, nome;
    private double numero;

    // Costruttore senza parametri
    public Contatto() {
        cognome = "";
        nome = "";
        numero = 0;
    }

    // Costruttore con parametri
    public Contatto(String cognome, String nome, double numero) {
        this.cognome = cognome;
        this.nome = nome;
        this.numero = numero;
    }

    // Getter e Setter
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    // Metodo per inserire i dettagli del contatto
    public void inserimento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il cognome:");
        cognome = sc.nextLine();
        System.out.println("Inserisci il nome:");
        nome = sc.nextLine();
        System.out.println("Inserisci il numero:");
        numero = sc.nextDouble();
        sc.nextLine(); // Per svuotare il buffer

        // Scrivere nel file
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomeFile, true))) {  // 'true' per appendere
            pw.println(cognome + "," + nome + "," + numero);  // Scrive nel file separando con virgole
            System.out.println("Contatto aggiunto con successo!");
        } catch (IOException e) {
            System.out.println("Errore durante la scrittura del file: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Contatto{" + "cognome='" + cognome + '\'' + ", nome='" + nome + '\'' + ", numero=" + numero + '}';
    }

    // Metodo per visualizzare il contatto
    public void visualizza() {
        System.out.println(this.toString());
    }
}