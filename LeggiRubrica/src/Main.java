import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creiamo un oggetto Gestore per gestire la rubrica
        Gestore rubrica = new Gestore();
        Scanner sc = new Scanner(System.in);
        boolean continua = true;

        // Menu principale per l'interazione con l'utente
        while (continua) {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Visualizza tutti i contatti");
            System.out.println("2. Cerca numero di contatto");
            System.out.println("3. Esci");

            int scelta = sc.nextInt();
            sc.nextLine();  // Pulisce il buffer del tastiera

            switch (scelta) {
                case 1:
                    // Visualizza tutti i contatti
                    rubrica.visualizzaRubrica();
                    break;
                case 2:
                    // Cerca un contatto specifico
                    System.out.println("Inserisci cognome del contatto da cercare:");
                    String cognome = sc.nextLine();
                    System.out.println("Inserisci nome del contatto da cercare:");
                    String nome = sc.nextLine();
                    Double numero = rubrica.cercaNumero(cognome, nome);
                    if (numero != null) {
                        System.out.println("Numero trovato: " + numero);
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 3:
                    // Esci dal programma
                    continua = false;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
    }
}
