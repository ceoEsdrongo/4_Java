import java.util.Vector;

/*Esercizio-2
In un file di testo 4AI.csv (‘;’ come separatore) sono memorizzate le informazioni degli
studenti della classe 4AI con cognome, nome e voto di informatica (intero).
Risolvere i seguenti punti:
1. leggere dal file i dati degli studenti e salvarli su un Vector o ArrayList
2. utilizzando il Vector o ArrayList precedentemente creato, salvare sul file
sufficienti.csv cognome e nome degli studenti con voto di informatica sufficiente*/
public class Main {
    public static void main(String[] args) {
        Vector<Studente> studenti = new Vector<>();
        Studente gestione = new Studente();
        gestione.anagrafica();
        gestione.salvaStudenti();
    }
}