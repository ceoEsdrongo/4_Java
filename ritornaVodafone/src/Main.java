import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestore rubrica = new Gestore();
        Scanner sc = new Scanner(System.in);
        boolean t = true;

        while (t) {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Elimina contatto");
            System.out.println("3. Aggiorna numero di contatto");
            System.out.println("4. Cerca numero di contatto");
            System.out.println("5. Visualizza contatti per lettera");
            System.out.println("6. Visualizza tutti i contatti");
            System.out.println("7. Esci");

            int scelta = sc.nextInt();
            sc.nextLine(); 
            switch (scelta) {
                case 1:
                    Contatto nuovo = new Contatto();
                    nuovo.inserimento();
                    rubrica.aggiungiContatto(nuovo);
                    break;
                case 2:
                    System.out.println("Inserisci cognome:");
                    String cognome = sc.nextLine();
                    System.out.println("Inserisci nome:");
                    String nome = sc.nextLine();
                    if (rubrica.eliminaContatto(cognome, nome)) {
                        System.out.println("Contatto eliminato.");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci cognome:");
                    cognome = sc.nextLine();
                    System.out.println("Inserisci nome:");
                    nome = sc.nextLine();
                    System.out.println("Inserisci nuovo numero:");
                    double nuovoNumero = sc.nextDouble();
                    if (rubrica.aggiornaNumero(cognome, nome, nuovoNumero)) {
                        System.out.println("Numero aggiornato.");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 4:
                    System.out.println("Inserisci cognome:");
                    cognome = sc.nextLine();
                    System.out.println("Inserisci nome:");
                    nome = sc.nextLine();
                    Double numero = rubrica.cercaNumero(cognome, nome);
                    if (numero != null) {
                        System.out.println("Numero trovato: " + numero);
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                    break;
                case 5:
                    System.out.println("Inserisci la lettera iniziale del cognome:");
                    char lettera = sc.next().charAt(0);
                    rubrica.visualizzaPerLettera(lettera);
                    break;
                case 6:
                    rubrica.visualizzaRubrica();
                    break;
                case 7:
                    t = false;
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }

    }
}

