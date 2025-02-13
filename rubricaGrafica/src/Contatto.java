import java.io.Serializable;
import java.util.Scanner;

public class Contatto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String nome, cognome;
    private String numero;

    public Contatto() {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    // SET
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    // GET
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumero() {
        return numero;
    }

    // METODO INSERISCI
    public void inserisci() {
        Scanner input = new Scanner(System.in);
        System.out.println("--- NUOVO CONTATTO ---");
        System.out.print("Inserisci il nome: ");
        nome = input.nextLine();
        System.out.print("Inserisci il cognome: ");
        cognome = input.nextLine();
        System.out.print("Inserisci il numero di telefono: ");
        numero = input.nextLine();

    }

    // METODO VISUALIZZA
    public void visualizza() {
        System.out.println("Nome: " + nome);
        System.out.println("Cognome: " + cognome);
        System.out.println("Numero: " + numero);
        System.out.println();
    }

}
