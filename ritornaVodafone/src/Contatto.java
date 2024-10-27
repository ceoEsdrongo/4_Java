/*Implementare una rubrica telefonica con contatti caratterizzati da cognome, nome e numero di
telefono. Si supponga che ogni contatto abbia un solo numero di telefono.
La rubrica deve presentare le seguenti funzionalità:
1. inserimento di un nuovo contatto (controllare che non sia già presente…)
2. eliminazione di un contatto in base al cognome e nome
3. aggiornamento del numero di telefono di un contatto fornito il cognome e nome
4. ricerca del numero di telefono di un contatto in base al cognome e nome
Realizzare un programma principale che permetta di realizzare una rubrica comprensiva delle
funzionalità descritte.
Seconda parte
Risolvere i seguenti punti:
A. realizzare l’inserimento di ogni nuovo contatto in modo da mantenere i contatti in ordine
alfabetico per cognome.
B. aggiungere la possibilità di scegliere dall’input una lettera dell’alfabeto e visualizzare solo
i soli contatti che hanno il cognome che inizia con quella lettera
C. aggiungere la possibilità (molto realistica…) che un contatto abbia più numeri di telefono*/


import java.util.Scanner;

public class Contatto {

    private String cognome, nome;
    private double numero;

    //classe senza costruttori
    public Contatto() {
        cognome = "";
        nome = "";
        numero = 5;
    }

    public Contatto(String cognome, String nome, Double numero) {
        this.cognome = cognome;
        this.nome = nome;
        this.numero = numero;
    }
    //getters setters

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

    public void inserimento() {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci il cognome");
        cognome = sc.nextLine();
        System.out.println("inserisci il nome");
        nome = sc.nextLine();
        System.out.println("inserisci il numero");
        numero = sc.nextDouble();
        sc.nextLine(); //svoto il buffer
    }

    @Override
    public String toString() {
        return "Contatto{" + "cognome='" + cognome + '\'' + ", nome='" + nome + '\'' + ", numero=" + numero + '}';
    }
    public void visualizza() {
        System.out.println(this.toString());
    }
}
