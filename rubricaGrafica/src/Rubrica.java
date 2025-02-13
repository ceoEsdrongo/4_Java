import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.Vector;

public class Rubrica implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Vector<Contatto> rubrica = new Vector<Contatto>(1, 20);
    private String nomeFile = "Rubrica.dat";

    public Rubrica() {
    }

    // CONTROLLO IL NUMERO DI TELEFONO
    public boolean controlloNumero() {
        for (int i = 0; i < rubrica.size(); i++) {
            String numeroCorrente = rubrica.get(i).getNumero();
            for (int j = i + 1; j < rubrica.size(); j++) {
                if (numeroCorrente.equals(rubrica.get(j).getNumero())) {
                    return false;
                }
            }
        }
        return true;
    }

    // 1
    // INSERIMENTO DI UN CONTATTO IN RUBRICA
    public void inserimento() {
        Contatto c = new Contatto();
        c.inserisci();
        rubrica.add(c);
        rubrica.trimToSize();
    }

    // 2
    // ELIMINAZIONE DI UN CONTATTO IN BASE AL NOME E IL COGNOME
    public void cancella() {
        Scanner input = new Scanner(System.in);
        String nome, cognome;
        boolean trovato = false;
        System.out.print("Inserisci il nome del contatto da eliminare: ");
        nome = input.nextLine();
        System.out.print("Inserisci il cognome del contatto da eliminare: ");
        cognome = input.nextLine();
        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getCognome().equalsIgnoreCase(cognome)
                    && rubrica.get(i).getNome().equalsIgnoreCase(nome)) {
                rubrica.remove(i);
                trovato = true;
                break;
            }
        }
        if (trovato == false)
            System.out.println("Nella rubrica non sono presenti contatti con questo nome e cognome!");
    }

    // 3
    // AGGIORNAMENTO DI UN CONTATTO IN BASE AL NOME E IL COGNOME
    public void aggiorna() {
        Scanner input = new Scanner(System.in);
        String nome, cognome, numero;
        boolean trovato = false;
        System.out.print("Inserisci il nome del contatto da eliminare: ");
        nome = input.nextLine();
        System.out.print("Inserisci il cognome del contatto da eliminare: ");
        cognome = input.nextLine();
        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getCognome().equalsIgnoreCase(cognome)
                    && rubrica.get(i).getNome().equalsIgnoreCase(nome)) {
                System.out.print("Inserisci il numero di telefono: ");
                numero = input.nextLine();
                trovato = true;
                break;
            }
        }
        if (trovato == false)
            System.out.println("Nella rubrica non sono presenti contatti con questo nome e cognome!");
    }

    // 4
    // RICERCA DI UN CONTATTO NELLA RUBRICA IN BASE AL NOME E COGNOME
    public void ricerca() {
        Scanner input = new Scanner(System.in);
        String nome, cognome;
        boolean trovato = false;
        System.out.print("Inserisci il nome del contatto da cercare: ");
        nome = input.nextLine();
        System.out.print("Inserisci il cognome del contatto da cercare: ");
        cognome = input.nextLine();
        for (int i = 0; i < rubrica.size(); i++) {
            if (rubrica.get(i).getCognome().equalsIgnoreCase(cognome)
                    && rubrica.get(i).getNome().equalsIgnoreCase(nome)) {
                rubrica.get(i).visualizza();
                trovato = true;
                break;
            }
        }
        if (trovato == false)
            System.out.println("Nella rubrica non sono presenti contatti con questo nome e cognome!");
    }

    // 5
    // VISUALIZZA LA RUBRICA
    public void visualizza() {
        System.out.println("--- CONTATTI ---");
        for (int i = 0; i < rubrica.size(); i++) {
            System.out.println();
            rubrica.get(i).visualizza();
        }
    }

    // SALVA LA RUBRICA IN UN FILE
    public void salvaRubrica() {
        try (FileOutputStream fos = new FileOutputStream("Rubrica.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Vector<Contatto> contattiVector = new Vector<>(rubrica);
            oos.writeObject(contattiVector);

            System.out.println("Rubrica salvata correttamente.");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio della rubrica: " + e.getMessage());
        }
    }



    // METODO PER LEGGERE UNA RUBRICA DAL FILE .dat
    public void leggiRubrica() {
        try {
            FileInputStream fis = new FileInputStream("Rubrica.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();

            if (obj instanceof Vector) {

                Vector<Contatto> contattiVector = (Vector<Contatto>) obj;
                rubrica.addAll(contattiVector);
                System.out.println("Rubrica importata correttamente!");
            } else {
                System.out.println("Errore: l'oggetto letto non è di tipo Vector");
            }

        } catch (IOException e) {
            System.out.println("Errore durante la lettura della rubrica: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

}