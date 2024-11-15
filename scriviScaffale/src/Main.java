import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Inserisci il nome della biblioteca: ");
        String nomeBiblioteca = sc.nextLine();

        Scaffale euganeo = new Scaffale(nomeBiblioteca);

        boolean t = true;

        while (t) {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Inserisci un nuovo libro");
            System.out.println("2. Visualizza tutta la biblioteca");
            System.out.println("3. Visualizza un libro tramite ISBN");
            System.out.println("4. Visualizza autore tramite titolo");
            System.out.println("5. Visualizza libri in un intervallo di prezzo");
            System.out.println("6. Visualizza libri di un certo argomento");
            System.out.println("7. Visualizza titolo del libro con prezzo più alto");
            System.out.println("8. Aggiorna le informazioni di un libro tramite ISBN");
            System.out.println("9. Cancella un libro tramite ISBN");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = sc.nextInt();
            sc.nextLine(); // Consuma newline

            switch (scelta) {
                case 1:
                    // Inserisci un nuovo libro
                    Libro nuovoLibro = new Libro();
                    nuovoLibro.inserimento();
                    euganeo.inserimento(nuovoLibro);
                    System.out.println("Libro aggiunto con successo!");
                    break;

                case 2:
                    // Visualizza tutta la biblioteca
                    euganeo.visualizza();
                    break;

                case 3:
                    // Visualizza informazioni di un libro dato l'ISBN
                    System.out.print("Inserisci l'ISBN del libro: ");
                    String isbn = sc.nextLine();
                    euganeo.visualizzaISBN(isbn);
                    break;

                case 4:
                    // Visualizza autore dato il titolo
                    System.out.print("Inserisci il titolo del libro: ");
                    String titolo = sc.nextLine();
                    euganeo.visualizzaAutore(titolo);
                    break;

                case 5:
                    // Visualizza libri con prezzo compreso tra min e max
                    System.out.print("Inserisci il prezzo minimo: ");
                    double min = sc.nextDouble();
                    System.out.print("Inserisci il prezzo massimo: ");
                    double max = sc.nextDouble();
                    euganeo.visualizzaRange(min, max);
                    break;

                case 6:
                    // Visualizza libri di un certo argomento
                    System.out.print("Inserisci l'argomento: ");
                    String argomento = sc.nextLine();
                    euganeo.argomento(argomento);
                    break;

                case 7:
                    // Visualizza titolo dei libri con prezzo più alto
                    euganeo.prezzoMax();
                    break;

                case 8:
                    // Aggiorna le informazioni di un libro dato l'ISBN
                    System.out.print("Inserisci l'ISBN del libro da aggiornare: ");
                    String isbnAggiornamento = sc.nextLine();
                    euganeo.aggiornaLibro(isbnAggiornamento);
                    break;


                case 9:
                    // Cancella un libro dato l'ISBN
                    System.out.print("Inserisci l'ISBN del libro da cancellare: ");
                    String isbnCancellazione = sc.nextLine();
                    euganeo.cancellaLibro(isbnCancellazione);
                    System.out.println("Libro cancellato con successo!");
                    break;

                case 0:
                    // Esci dal programma
                    System.out.println("Uscita dal programma...");
                    t = false;
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }


    }
}