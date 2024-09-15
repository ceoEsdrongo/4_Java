import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creiamo l'aereo "FR799"
        Aereo aereo = new Aereo("FR799", 4, "RYANAIR", "VENEZIA", "LONDRA", 50);

        // Inseriamo i passeggeri
        for (int i = 1; i <= 4; i++) {
            System.out.println("Inserisci i dati del passeggero " + i);

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Cognome: ");
            String cognome = scanner.nextLine();

            System.out.print("Peso bagaglio a mano: ");
            double pesoBagaglioMano = scanner.nextDouble();

            System.out.print("Peso bagaglio in stiva: ");
            double pesoBagaglioStiva = scanner.nextDouble();
            scanner.nextLine();  // Pulisci il buffer

            Passeggero passeggero = new Passeggero(cognome, nome, pesoBagaglioMano, pesoBagaglioStiva, 50);
            aereo.aggiungiPasseggero(passeggero);
        }

        // Visualizziamo le informazioni dell'aereo e dei passeggeri
        System.out.println("\nInformazioni dell'aereo e dei passeggeri:");
        aereo.visualizzaDettagli();

        // Calcoliamo il peso totale dei bagagli
        System.out.println("\nPeso totale dei bagagli: " + aereo.calcolaPesoTotaleBagagli() + " Kg");

        // Sostituiamo Mario Rossi con un altro passeggero
        System.out.println("\nIl passeggero Mario Rossi non può più partire. Sostituirlo.");
        aereo.rimuoviPasseggero("Mario", "Rossi");

        System.out.print("Nome del nuovo passeggero: ");
        String nomeNuovo = scanner.nextLine();

        System.out.print("Cognome del nuovo passeggero: ");
        String cognomeNuovo = scanner.nextLine();

        System.out.print("Peso bagaglio a mano del nuovo passeggero: ");
        double pesoBagaglioManoNuovo = scanner.nextDouble();

        System.out.print("Peso bagaglio in stiva del nuovo passeggero: ");
        double pesoBagaglioStivaNuovo = scanner.nextDouble();

        Passeggero nuovoPasseggero = new Passeggero(cognomeNuovo, nomeNuovo, pesoBagaglioManoNuovo, pesoBagaglioStivaNuovo, 50);
        aereo.aggiungiPasseggero(nuovoPasseggero);

        // Visualizziamo le informazioni aggiornate
        System.out.println("\nInformazioni aggiornate dell'aereo e dei passeggeri:");
        aereo.visualizzaDettagli();

        // Visualizziamo il passeggero che ha pagato di più
        System.out.println("\nIl passeggero che ha pagato di più:");
        aereo.visualizzaPasseggeroCheHaPagatoDiPiu();

        scanner.close();
    }
}
