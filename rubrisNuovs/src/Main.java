import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestore gestore = new Gestore();
        Scanner scanner = new Scanner(System.in);
        int scelta;

        do {
            System.out.println("\n--- Rubrica ---");
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Elimina contatto");
            System.out.println("3. Aggiorna numero");
            System.out.println("4. Cerca numero");
            System.out.println("5. Visualizza rubrica");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine(); // Pulisce il buffer

            switch (scelta) {
                case 1 -> {
                    System.out.print("Inserisci cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci numero: ");
                    double numero = scanner.nextDouble();
                    Contatto nuovoContatto = new Contatto(cognome, nome, numero);
                    gestore.aggiungiContatto(nuovoContatto);
                    System.out.println("Contatto aggiunto!");
                }
                case 2 -> {
                    System.out.print("Inserisci cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    if (gestore.eliminaContatto(cognome, nome)) {
                        System.out.println("Contatto eliminato!");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                }
                case 3 -> {
                    System.out.print("Inserisci cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Inserisci nuovo numero: ");
                    double nuovoNumero = scanner.nextDouble();
                    if (gestore.aggiornaNumero(cognome, nome, nuovoNumero)) {
                        System.out.println("Numero aggiornato!");
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                }
                case 4 -> {
                    System.out.print("Inserisci cognome: ");
                    String cognome = scanner.nextLine();
                    System.out.print("Inserisci nome: ");
                    String nome = scanner.nextLine();
                    Double numero = gestore.cercaNumero(cognome, nome);
                    if (numero != null) {
                        System.out.println("Numero trovato: " + numero);
                    } else {
                        System.out.println("Contatto non trovato.");
                    }
                }
                case 5 -> gestore.visualizzaRubrica();
                case 0 -> System.out.println("Uscita...");
                default -> System.out.println("Scelta non valida!");
            }
        } while (scelta != 0);
    }
}