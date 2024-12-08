import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Admin implements Serializable {
    private Vector<Admin> user = new Vector<>();
    private final String employers = "utenti.dat"; // File
    private String nome, cognome, password;
    transient Scanner sc = new Scanner(System.in);

    // Costruttore con parametri
    public Admin(String nome, String cognome, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    // Costruttore vuoto
    public Admin() {
        caricaUtenti(); // Carica utenti esistenti dal file
    }

    // Metodo per caricare gli utenti dal file
    private void caricaUtenti() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(employers));
            user = (Vector<Admin>) in.readObject();
            in.close();
        } catch (Exception e) {
            user = new Vector<>(); // Se fallisce, inizializza un nuovo elenco vuoto
            System.out.println("File non trovato o vuoto. Inizializzato un nuovo elenco.");
        }
    }

    // Metodo per inserire nuovi utenti e verificare credenziali
    public void inserimento() {
        System.out.println("Inserisci il nome:");
        nome = sc.nextLine();
        System.out.println("Inserisci la password:");
        password = sc.nextLine();

        // Controllo se l'utente esiste già
        boolean trovato = false;
        for (Admin a : user) {
            if (a.nome.equals(nome) && a.password.equals(password)) {
                System.out.println("Accesso consentito. Benvenuto, " + nome + "!");
                trovato = true;
                break;
            }
        }

        if (!trovato) {
            System.out.println("Utente non trovato. Vuoi registrarlo? (si/no)");
            String risposta = sc.nextLine();
            if (risposta.equalsIgnoreCase("si")) {
                System.out.println("Inserisci il cognome:");
                cognome = sc.nextLine();
                user.add(new Admin(nome, cognome, password));
                System.out.println("Utente registrato correttamente!");
                salvaUtente();
            } else {
                System.out.println("Operazione annullata.");
            }
        }
    }

    // Metodo per salvare gli utenti nel file
    private void salvaUtente() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(employers))) {
            out.writeObject(user);
            System.out.println("Dati salvati correttamente!");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }
    public void mostraUtentiSalvati() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(employers));
            Vector<Admin> utentiRegistrati = (Vector<Admin>) in.readObject();
            for (Admin a : utentiRegistrati) {
                System.out.println(a.nome + " " + a.cognome + " " + a.password);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Errore o file vuoto.");
        }
    }

}