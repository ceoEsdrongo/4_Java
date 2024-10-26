import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scaffale biblioteca = new Scaffale("Biblioteca dell'Euganeo", 100);
        int scelta;

        do {
            System.out.println("Scegli un'azione:");
            System.out.println("1 -> Inserisci un nuovo libro");
            System.out.println("2 -> Rimuovi un libro");
            System.out.println("3 -> Visualizza tutta la biblioteca");
            System.out.println("4 -> Visualizza libro per ISBN");
            System.out.println("5 -> Visualizza autore per titolo");
            System.out.println("6 -> Visualizza libri per prezzo");
            System.out.println("7 -> Visualizza libri per argomento");
            System.out.println("8 -> Visualizza titolo del libro con il prezzo più alto");
            System.out.println("9 -> Aggiorna informazioni di un libro");
            System.out.println("10 -> Esci dal programma");
            scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    Libro libro = new Libro();
                    libro.inserisci();
                    biblioteca.inserisciLibro(libro);
                    break;

                case 2:
                    System.out.println("Inserisci l'ISBN del libro da rimuovere:");
                    String isbnDaTogliere = sc.nextLine();
                    biblioteca.cancellaLibro(isbnDaTogliere);
                    break;

                case 3:
                    System.out.println("Elenco dei libri nello scaffale:");
                    biblioteca.visualizzaScaffale();
                    break;

                case 4:
                    System.out.println("Inserisci l'ISBN del libro da visualizzare:");
                    String isbnDaVisualizzare = sc.nextLine();
                    biblioteca.visualizzaLibroPerISBN(isbnDaVisualizzare);
                    break;

                case 5:
                    System.out.println("Inserisci il titolo del libro:");
                    String titoloDaCercare = sc.nextLine();
                    biblioteca.visualizzaAutorePerTitolo(titoloDaCercare);
                    break;

                case 6:
                    System.out.println("Inserisci il prezzo minimo:");
                    double minPrezzo = sc.nextDouble();
                    System.out.println("Inserisci il prezzo massimo:");
                    double maxPrezzo = sc.nextDouble();
                    biblioteca.visualizzaLibriPerPrezzo(minPrezzo, maxPrezzo);
                    sc.nextLine(); // Consuma la newline residua
                    break;

                case 7:
                    System.out.println("Inserisci l'argomento:");
                    String argomentoDaCercare = sc.nextLine();
                    biblioteca.visualizzaLibriPerArgomento(argomentoDaCercare);
                    break;

                case 8:
                    biblioteca.visualizzaTitoloPrezzoMassimo();
                    break;

                case 9:
                    System.out.println("Inserisci l'ISBN del libro da aggiornare:");
                    String isbnDaAggiornare = sc.nextLine();
                    System.out.println("Inserisci il nuovo titolo:");
                    String nuovoTitolo = sc.nextLine();
                    System.out.println("Inserisci il nuovo autore:");
                    String nuovoAutore = sc.nextLine();
                    System.out.println("Inserisci il nuovo argomento:");
                    String nuovoArgomento = sc.nextLine();
                    System.out.println("Inserisci il nuovo prezzo:");
                    double nuovoPrezzo = sc.nextDouble();
                    biblioteca.aggiornaLibro(isbnDaAggiornare, nuovoTitolo, nuovoAutore, nuovoArgomento, nuovoPrezzo);
                    sc.nextLine();
                    break;

                case 10:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 10);

    }
}
