import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crea la biblioteca e carica i libri dal file
        Scaffale biblioteca = new Scaffale();

        // Interfaccia utente semplice per visualizzare i libri
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Visualizza tutti i libri");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();  // Consuma il newline dopo il numero

            switch (scelta) {
                case 1:
                    // Visualizza tutti i libri caricati
                    biblioteca.visualizzaLibri();
                    break;
                case 0:
                    continua = false;
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Opzione non valida, riprova.");
                    break;
            }
        }


    }
}
