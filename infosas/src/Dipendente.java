/*Si vogliono gestire le informazioni relative agli stipendi dei dipendenti di una azienda. Per ogni dipendente
si memorizza il codice fiscale (stringa 16 caratteri), cognome (stringa), nome (stringa) e stipendio (intero
positivo).
Realizzare la classe Dipendente con costruttori, set e get (solo per un attributo), toString, un metodo per
l’inserimento (controllo sullo stipendio) e il metodo visualizza.
Realizzare un programma principale con le seguenti funzionalità:
1. creare un vector o arrayList di 120 dipendenti (con controllo sulla unicità del codice fiscale)
2. visualizzare le informazioni di tutti i dipendenti
3. visualizzare le informazioni di un dipendente dato il codice fiscale
4. aumentare del 10% lo stipendio di un dipendente dato il suo codice fiscale
5. cancellare un dipendente dato il suo codice fiscale
6. memorizzare in un altro vector/arrayList l’elenco dei dipendenti che hanno uno stipendio che
supera i 4.000€*/


import java.util.Scanner;

public class Dipendente {
    private String CF, cognome, nome;
    private int stipendio;

    public Dipendente() {
        CF = "";
        cognome = "";
        nome = "";
        stipendio = 0;
    }

    public Dipendente(String CF, String cognome, String nome, int stipendio) {
        this.CF = CF;
        this.cognome = cognome;
        this.nome = nome;
        this.stipendio = stipendio;
    }
    //getters setters

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
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

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public void inserimento() {
        Scanner sc = new Scanner(System.in);
        if (CF.length() == 16) {
            System.out.println("innserire il codice fiscale ");
            CF = sc.nextLine();
        }
        System.out.println("inserire il cognome");
        cognome = sc.nextLine();
        System.out.println("inserisci il nome");
        nome = sc.nextLine();
    }
    //toString

    @Override
    public String toString() {
        return "Dipendente{" + "CF='" + CF + '\'' + ", cognome='" + cognome + '\'' + ", nome='" + nome + '\'' + ", stipendio=" + stipendio + '}';
    }
    public void visualizza(){
        System.out.println(this.toString());
    }
}
