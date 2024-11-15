import java.util.Scanner;

public class Contatto {

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

    // Metodo per inserire i dati del contatto
    public void inserimento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il cognome:");
        cognome = sc.nextLine();
        System.out.println("Inserisci il nome:");
        nome = sc.nextLine();
        System.out.println("Inserisci il numero di telefono:");
        numero = sc.nextDouble();
        sc.nextLine();  // Pulisce il buffer
    }

    // Metodo per visualizzare il contatto
    public void visualizza() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Contatto{" + "cognome='" + cognome + '\'' + ", nome='" + nome + '\'' + ", numero=" + numero + '}';
    }
}
