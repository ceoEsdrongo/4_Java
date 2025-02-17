import java.io.Serializable;

public class Contatto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome, cognome, numero, foto;

    public Contatto(String nome, String cognome, String numero, String foto) {
        this.nome = nome;
        this.cognome = cognome;
        this.numero = numero;
        this.foto = (foto != null && !foto.isEmpty()) ? foto : "default.png";
    }

    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getNumero() { return numero; }
    public String getFoto() { return foto; }  // Metodo per ottenere il percorso della foto
}
