public class Contatto {
    private String cognome;
    private String nome;
    private double numero;

    public Contatto() {}

    public Contatto(String cognome, String nome, double numero) {
        this.cognome = cognome;
        this.nome = nome;
        this.numero = numero;
    }

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

    @Override
    public String toString() {
        return "Cognome: " + cognome + ", Nome: " + nome + ", Numero: " + numero;
    }
}
