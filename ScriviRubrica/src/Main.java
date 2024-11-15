import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creiamo un oggetto Gestore per gestire la rubrica
        Gestore rubrica = new Gestore();
        Scanner sc = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            // Mostriamo il menu all'utente
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Elimina contatto");
            System.out.println("3. Aggiorna numero di contatto");
            System.out.println("4. Cerca numero di contatto");
            System.out.println("5. Visualizza contatti per lettera");
            System.out.println("6. Visualizza tutti i contatti");
            System.out.println("7. Esci");

            int scelta = sc.nextInt();
            sc.nextLine(); // Svuota il buffer
            switch (scelta) {
                case 1:
                    // Aggiungi un nuovo contatto
                    Contatto nuovo = new Contatto();
                    nuovo.inserimento();  // Richiama il metodo per inserire il contatto e scrivere nel file
                    rubrica.aggiungiContatto(nuovo);  // Aggiungi contatto alla rubrica
                    break;
                case 2:
                    // Elimina un contatto
                    System.out.println("Inserisci cognome del contatto da eliminare:");
                    String cognome = sc.nextLine();
                    System.out.println("Inserisci nome del contatto da eliminare:");
                    String nome = sc.nextLine();
                    if (rubrica.eliminaContatto(cognome, nome)) {
                        System.out.println("Contatto eliminato.");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 3:
                    // Aggiorna il numero di telefono di un contatto
                    System.out.println("Inserisci cognome del contatto da aggiornare:");
                    cognome = sc.nextLine();
                    System.out.println("Inserisci nome del contatto da aggiornare:");
                    nome = sc.nextLine();
                    System.out.println("Inserisci il nuovo numero:");
                    double nuovoNumero = sc.nextDouble();
                    if (rubrica.aggiornaNumero(cognome, nome, nuovoNumero)) {
                        System.out.println("Numero aggiornato.");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 4:
                    // Cerca il numero di telefono di un contatto
                    System.out.println("Inserisci cognome del contatto da cercare:");
                    cognome = sc.nextLine();
                    System.out.println("Inserisci nome del contatto da cercare:");
                    nome = sc.nextLine();
                    Double numero = rubrica.cercaNumero(cognome, nome);
                    if (numero != null) {
                        System.out.println("Numero trovato: " + numero);
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 5:
                    // Visualizza contatti che iniziano con una lettera specifica
                    System.out.println("Inserisci la lettera iniziale del cognome:");
                    char lettera = sc.next().charAt(0);
                    rubrica.visualizzaPerLettera(lettera);
                    break;
                case 6:
                    // Visualizza tutti i contatti
                    rubrica.visualizzaRubrica();
                    break;
                case 7:
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
