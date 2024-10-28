/*Si vogliono gestire le informazioni relative agli stipendi dei dipendenti di una azienda. Per ogni dipendente
si memorizza il codice fiscale (stringa 16 caratteri), cognome (stringa), nome (stringa) e stipendio (intero
positivo).
Realizzare la classe Dipendente con costruttori, set e get (solo per un attributo), toString, un metodo per
l’inserimento (controllo sullo stipendio) e il metodo visualizza.
Realizzare un programma principale con le seguenti funzionalità:
1. creare un vector o arrayList di 120 dipendenti (con controllo sulla unicità del codice fiscale)
2. visualizzare le informazioni di tutti i dipendenti
3. visualizzare le informazioni di un dipendente dato il codice fiscale
4. aumentare del 10% lo stipendio di un dipendente dato il suo codice fiscale
5. cancellare un dipendente dato il suo codice fiscale
6. memorizzare in un altro vector/arrayList l’elenco dei dipendenti che hanno uno stipendio che
supera i 4.000€*/




/*Si vogliono gestire le informazioni relative agli stipendi dei dipendenti di una azienda. Per ogni dipendente
si memorizza il codice fiscale (stringa 16 caratteri), cognome (stringa), nome (stringa) e stipendio (intero
positivo).
Realizzare la classe Dipendente con costruttori, set e get (solo per un attributo), toString, un metodo per
l’inserimento (controllo sullo stipendio) e il metodo visualizza.
Realizzare un programma principale con le seguenti funzionalità:
1. creare un vector o arrayList di 120 dipendenti (con controllo sulla unicità del codice fiscale)
2. visualizzare le informazioni di tutti i dipendenti
3. visualizzare le informazioni di un dipendente dato il codice fiscale
4. aumentare del 10% lo stipendio di un dipendente dato il suo codice fiscale
5. cancellare un dipendente dato il suo codice fiscale
6. memorizzare in un altro vector/arrayList l’elenco dei dipendenti che hanno uno stipendio che
supera i 4.000€*/


import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Dipendente> dipendenti = new Vector<>();
        Vector<Dipendente> stipendiElevati = new Vector<>();

        while (dipendenti.size() < 120) {
            Dipendente dip = new Dipendente();
            dip.inserimento();
            if (isUniqueCF(dipendenti, dip.getCF())) {
                System.out.println("Inserire lo stipendio (deve essere positivo):");
                int stipendio = scanner.nextInt();
                while (stipendio <= 0) {
                    System.out.println("Stipendio non valido. Riprova:");
                    stipendio = scanner.nextInt();
                }
                dip.setStipendio(stipendio);
                dipendenti.add(dip);
            } else {
                System.out.println("Codice fiscale già presente. Riprova.");
            }
            scanner.nextLine();
        }

        // Visualizza tutti i dipendenti
        System.out.println("Lista di tutti i dipendenti:");
        for (Dipendente dip : dipendenti) {
            dip.visualizza();
        }

        // Visualizza un dipendente dato il codice fiscale
        System.out.println("Inserire il codice fiscale per visualizzare le informazioni:");
        String cfDaCercare = scanner.nextLine();
        Dipendente dipendenteTrovato = findDipendenteByCF(dipendenti, cfDaCercare);
        if (dipendenteTrovato != null) {
            dipendenteTrovato.visualizza();
        } else {
            System.out.println("Dipendente non trovato.");
        }

        // Aumenta stipendio del 10%
        System.out.println("Inserire il codice fiscale per aumentare lo stipendio del 10%:");
        String cfAumento = scanner.nextLine();
        dipendenteTrovato = findDipendenteByCF(dipendenti, cfAumento);
        if (dipendenteTrovato != null) {
            int nuovoStipendio = (int) (dipendenteTrovato.getStipendio() * 1.1);
            dipendenteTrovato.setStipendio(nuovoStipendio);
            System.out.println("Stipendio aggiornato:");
            dipendenteTrovato.visualizza();
        } else {
            System.out.println("Dipendente non trovato.");
        }

        // Cancellare un dipendente
        System.out.println("Inserire il codice fiscale per cancellare il dipendente:");
        String cfDaCancellare = scanner.nextLine();
        dipendenteTrovato = findDipendenteByCF(dipendenti, cfDaCancellare);
        if (dipendenteTrovato != null) {
            dipendenti.remove(dipendenteTrovato);
            System.out.println("Dipendente cancellato.");
        } else {
            System.out.println("Dipendente non trovato.");
        }

        // Memorizza dipendenti con stipendio > 4000
        for (Dipendente dip : dipendenti) {
            if (dip.getStipendio() > 4000) {
                stipendiElevati.add(dip);
            }
        }

        // Visualizza dipendenti con stipendio > 4000
        System.out.println("Dipendenti con stipendio superiore a 4000€:");
        for (Dipendente dip : stipendiElevati) {
            dip.visualizza();
        }

        
    }

    private static boolean isUniqueCF(Vector<Dipendente> dipendenti, String cf) {
        for (Dipendente dip : dipendenti) {
            if (dip.getCF().equals(cf)) {
                return false;
            }
        }
        return true;
    }

    private static Dipendente findDipendenteByCF(Vector<Dipendente> dipendenti, String cf) {
        for (Dipendente dip : dipendenti) {
            if (dip.getCF().equals(cf)) {
                return dip;
            }
        }
        return null;
    }
}
