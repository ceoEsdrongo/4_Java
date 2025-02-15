import java.io.Serializable;

public class Contatto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome, cognome, numero;

    public Contatto() {}

    public Contatto(String nome, String cognome, String numero) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
    }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public void setNumero(String numero) { this.numero = numero; }

    // Getters
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getNumero() { return numero; }

    // Metodo per visualizzare il contatto
    public String toString() {
        return "Nome: " + nome + "\nCognome: " + cognome + "\nNumero: " + numero + "\n";
    }
}
