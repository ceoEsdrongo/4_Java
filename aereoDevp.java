--------------Main
/*Per ogni passeggero si deve memorizzare: cognome, nome, peso bagaglio a mano, peso
bagaglio in stiva, costo del biglietto (costo base e costo bagagli).
Il costo bagagli viene così calcolato: il bagaglio a mano costa 10 € se il peso è minore di 10 Kg,
oltre i 10 Kg si paga 2€ per ogni Kg in più, il bagaglio in stiva costa 30 € se il peso è minore di 20
Kg, altrimenti costa 5 € per ogni Kg in più.
L’aereo memorizza il numero dell’aereo, il numeo max di posti, il nome della compagnia aerea, il
luogo di partenza, il luogo di destinazione ed l’elenco dei passeggeri.
Si chiede di
1. creare la classe Passeggero con l’inserimento dall’input e la visualizzazione del cognome,
nome e costo del biglietto
2. creare l’aereo numero “FR799”, max 4 posti, compagnia “RYANAIR”, luogo di partenza
“VENEZIA”, luogo di destinazione “LONDRA”, costo di base del viaggio 50€ ed inserire i dati
relativi a tutti i passeggeri.
3. visualizzare le informazioni dell’aereo e dei suoi passeggeri
4. determinare il peso totale di tutti i bagagli
5. all’ultimo momento il passeggero Mario Rossi (si ipotizzi che ne esista uno solo con questo nome e
cognome) non può più partire, viene quindi sostituito da un altro passeggero: realizzare la
sostituzione
6. visualizzare le informazioni del passeggero (o passeggeri) che ha pagato più di tutti gli altri*/


public class Main {
    public static void main(String[] args) {
        Aereo aereo = new Aereo("FR799", 4, "RYANAIR", "VENEZIA", "LONDRA", 50);


        Passeggero p1 = new Passeggero();
        p1.inserisci();

        Passeggero p2 = new Passeggero();
        p2.inserisci();
        Passeggero p3 = new Passeggero();
        p3.inserisci();

        Passeggero p4 = new Passeggero();
        p4.inserisci();


        aereo.aggiungiPasseggero(p1);
        aereo.aggiungiPasseggero(p2);
        aereo.aggiungiPasseggero(p3);
        aereo.aggiungiPasseggero(p4);


        aereo.visualizzaDettagli();
        aereo.calcolaPesoTotaleBagagli();
        aereo.visualizzaPasseggeroCheHaPagatoDiPiu();
        
    }
}



-------------Passeggero
import java.util.Scanner;

public class Passeggero {
    private final int costoBase; //biglietto
    private String nome, cognome;
    private int pesoMano;
    private int pesoStiva;
    final int costoBaseBagaglioMano=10,pesoBagaglioMano=10,costoMaggBagaglioMano=2,costoBaseBagaglioStiva=30,pesoBaseBagaglioStiva=20,costoMaggBagaglioStiva=5;

    //costruttore
    public Passeggero() {
        nome = "";
        cognome = "";
        pesoMano = 0;
        pesoStiva = 0;
        costoBase = 50;
    }

    public Passeggero(String nome, String cognome, int pesoMano, int pesoStiva, int costoBase) {
        this.nome = nome;
        this.cognome = cognome;
        this.pesoMano = pesoMano;
        this.pesoStiva = pesoStiva;
        this.costoBase = 50;
    }

    //get
    public String getNome() {
        return nome;
    }

    //set
    public void setNome(String nome) {
        //eventuali controlli
        this.nome = nome;
    }
    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    //sovrascrive il comportamento di tutti gli oggetti di tipo Passeggero

                                /*public String toString(){
                                    return "ciao";
                                }*/

    public void inserisci() {
        Scanner sc = new Scanner(System.in);
        System.out.println("inserisci il nome");
        nome = sc.nextLine();
        System.out.println("inserisci il cognome");
        cognome = sc.nextLine();
        System.out.println("inserisci il peso bagaglio mano");
        pesoMano = sc.nextInt();
        sc.nextLine();
        System.out.println("inserisci il peso bagaglio stiva");
        pesoStiva = sc.nextInt();
        sc.nextLine();
    }


    @Override
    public String toString() {
        return "Passeggero{" + "nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", pesoMano=" + pesoMano + ", pesoStiva=" + pesoStiva + ", costoBase=" + costoBase + '}';
    }
    public void visualizza(){
        System.out.println(this.toString());
    }
    public int getCostoBiglietto(){
        int c=costoBase;

        c+=costoBaseBagaglioMano;
        if(pesoMano>=pesoBagaglioMano) {
            c += (pesoMano - pesoBagaglioMano) * costoMaggBagaglioMano;
        }
        c+=costoBaseBagaglioStiva;
        if(pesoStiva>pesoBaseBagaglioStiva){
            c+=(pesoStiva-pesoBaseBagaglioStiva)*costoMaggBagaglioStiva;
        }
        return c;
    }
}
 ------------Aereo
   import java.util.Scanner;

public class Aereo {
    private String numeroAereo;
    private int maxPosti;
    private String compagniaAerea;
    private String luogoPartenza;
    private String luogoDestinazione;
    private double costoBase;
    private Passeggero[] passeggeri;
    private int numPasseggeri;

    // Costruttore
    public Aereo() {
        this.numeroAereo = "";
        this.maxPosti = 0;
        this.compagniaAerea = "";
        this.luogoPartenza = "";
        this.luogoDestinazione = "";
        this.costoBase = 0;
        this.numPasseggeri = 0;
    }

    public Aereo(String numeroAereo, int maxPosti, String compagniaAerea, String luogoPartenza, String luogoDestinazione, double costoBase) {
        this.numeroAereo = numeroAereo;
        this.maxPosti = maxPosti;
        this.compagniaAerea = compagniaAerea;
        this.luogoPartenza = luogoPartenza;
        this.luogoDestinazione = luogoDestinazione;
        this.costoBase = costoBase;
        this.passeggeri = new Passeggero[maxPosti];
        this.numPasseggeri = 0;
    }

    // Metodo per aggiungere un passeggero
    public void aggiungiPasseggero(Passeggero passeggero) {
        if (numPasseggeri < maxPosti) {
            passeggeri[numPasseggeri] = passeggero;
            numPasseggeri++;
        } else {
            System.out.println("Aereo al completo, non è possibile aggiungere altri passeggeri.");
        }
    }

    // Metodo per visualizzare le informazioni dell'aereo e dei passeggeri
    public void visualizzaDettagli() {
        System.out.println("Numero Aereo: " + numeroAereo);
        System.out.println("Compagnia Aerea: " + compagniaAerea);
        System.out.println("Luogo di Partenza: " + luogoPartenza);
        System.out.println("Luogo di Destinazione: " + luogoDestinazione);
        System.out.println("Passeggeri:");
        for (int i = 0; i < numPasseggeri; i++) {
            passeggeri[i].visualizza();
        }
    }

    // Metodo per calcolare il peso totale dei bagagli
    public double calcolaPesoTotaleBagagli() {
        double pesoTotale = 0;
        for (int i = 0; i < numPasseggeri; i++) {
            pesoTotale += passeggeri[i].pesoBagaglioMano + passeggeri[i].pesoBaseBagaglioStiva;
        }
        return pesoTotale;
    }

    // Metodo per sostituire un passeggero
    public void sostituisciPasseggero(String nome, String cognome, Passeggero nuovoPasseggero) {
        for (int i = 0; i < numPasseggeri; i++) {
            if (passeggeri[i].getNome().equalsIgnoreCase(nome) && passeggeri[i].getCognome().equalsIgnoreCase(cognome)) {
                passeggeri[i] = nuovoPasseggero;
                System.out.println("Passeggero sostituito con successo.");
                return;
            }
        }
        System.out.println("Passeggero non trovato.");
    }

    // Metodo per visualizzare il passeggero che ha pagato di più
    public void visualizzaPasseggeroCheHaPagatoDiPiu() {
        Passeggero passeggeroCheHaPagatoDiPiu = null;
        for (int i = 0; i < numPasseggeri; i++) {
            if (passeggeroCheHaPagatoDiPiu == null || passeggeri[i].getCostoBiglietto() > passeggeroCheHaPagatoDiPiu.getCostoBiglietto()) {
                passeggeroCheHaPagatoDiPiu = passeggeri[i];
            }
        }
        if (passeggeroCheHaPagatoDiPiu != null) {
            System.out.println("Il passeggero che ha pagato di più è:");
            passeggeroCheHaPagatoDiPiu.visualizza();
        }
    }

    public void inserisci() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci il numero Aereo:");
        numeroAereo = sc.nextLine();
        System.out.println("Inserisci il numero massimo di posti:");
        maxPosti = sc.nextInt();
        sc.nextLine();
        System.out.println("Inserisci la compagnia aerea:");
        compagniaAerea = sc.nextLine();
        System.out.println("Inserisci il luogo di partenza:");
        luogoPartenza = sc.nextLine();
        System.out.println("Inserisci il luogo di destinazione:");
        luogoDestinazione = sc.nextLine();
        System.out.println("Inserisci il costo base:");
        costoBase = sc.nextDouble();
        passeggeri = new Passeggero[maxPosti]; // Inizializza l'array dei passeggeri
        numPasseggeri = 0; // Reset del conteggio dei passeggeri
    }


}

   
  
