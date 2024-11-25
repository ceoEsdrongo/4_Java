import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scaffale biblioteca = new Scaffale("Biblioteca");

        boolean continua = true;

        while (continua) {
            System.out.println("\n--- Biblioteca ---");
            System.out.print("Scegli un'opzione: ");
            System.out.println("\n1. Inserisci un nuovo libro");
            System.out.println("2. Visualizza tutta la biblioteca");
            System.out.println("3. Visualizza un libro tramite ISBN");
            System.out.println("4. Visualizza autore tramite titolo");
            System.out.println("5. Visualizza libri in un intervallo di prezzo");
            System.out.println("6. Visualizza libri di un certo argomento");
            System.out.println("7. Visualizza titolo del libro con prezzo più alto");
            System.out.println("8. Aggiorna le informazioni di un libro tramite ISBN");
            System.out.println("9. Cancella un libro tramite ISBN");
            System.out.println("0. Esci\n");


            int scelta = sc.nextInt();
            sc.nextLine(); // Consuma newline

            switch (scelta) {
                case 1:
                    // Inserisci un nuovo libro
                    Libro nuovoLibro = new Libro();
                    nuovoLibro.inserimento(); // Metodo inserimento nella classe Libro
                    biblioteca.inserimento(nuovoLibro);
                    System.out.println("Libro aggiunto con successo!");
                    break;
                case 2:
                    biblioteca.visualizza();
                    break;
                case 3:
                    System.out.print("Inserisci l'ISBN del libro: ");
                    String isbn = sc.nextLine();
                    biblioteca.visualizzaISBN(isbn);
                    break;
                case 4:
                    System.out.print("Inserisci il titolo del libro: ");
                    String titolo = sc.nextLine();
                    biblioteca.visualizzaAutore(titolo);
                    break;
                case 5:
                    System.out.print("Inserisci il prezzo minimo: ");
                    double min = sc.nextDouble();
                    System.out.print("Inserisci il prezzo massimo: ");
                    double max = sc.nextDouble();
                    biblioteca.visualizzaRange(min, max);
                    break;
                case 6:
                    System.out.print("Inserisci l'argomento: ");
                    String argomento = sc.nextLine();
                    biblioteca.argomento(argomento);
                    break;
                case 7:
                    biblioteca.prezzoMax();
                    break;
                case 8:
                    System.out.print("Inserisci l'ISBN del libro da aggiornare: ");
                    String isbnAggiornamento = sc.nextLine();
                    biblioteca.aggiornaLibro(isbnAggiornamento);
                    break;
                case 9:
                    System.out.print("Inserisci l'ISBN del libro da cancellare: ");
                    String isbnDaCancellare = sc.nextLine();
                    biblioteca.cancellaLibro(isbnDaCancellare);
                    break;
                case 0:
                    continua = false;
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }
    }
}
