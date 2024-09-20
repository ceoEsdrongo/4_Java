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




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Passeggero p = new Passeggero();
        p.inserisci();
        p.visualizza();
        

    }
}

------------------------
  Passeggero.java
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
    /*public void visualizza(){

    }*/

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

---------------------
    Aereo.java
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


public class Aereo {
    private String numeroAereo;
    private int maxPosti = 4;
    private String compagniaAerea;
    private String decollo, arrivo;
    private double costoBase;
    private Passeggero[] passeggeri;
    private int numPasseggeri;

    //costruttore
    Aereo(String numeroAereo, int maxPosti, String compagniaAerea, String decollo, String arrivo, double costoBase, Passeggero[] passeggeri, int numPasseggeri) {
        this.numeroAereo = numeroAereo;
        this.maxPosti = maxPosti;
        this.compagniaAerea = compagniaAerea;
        this.decollo = decollo;
        this.arrivo = arrivo;
        this.costoBase = costoBase;
        this.passeggeri = new Passeggero[maxPosti];
        this.numPasseggeri = numPasseggeri = 0;
    }

    //metodo passeggeri
    public void aggiungiPasseggero(Passeggero passeggero) {
        if (numPasseggeri < maxPosti) {
            passeggeri[numPasseggeri] = passeggero;
            numPasseggeri++;
        } else {
            System.out.println("passeggeri pieni");
        }
    }

    public void rimuoviPasseggero(String nome, String cognome) {
        for (int i = 0; i < numPasseggeri; i++) {
            if (passeggeri[i].getNome().equalsIgnoreCase(nome) && passeggeri[i].getCognome().equalsIgnoreCase(cognome)) {
                for (int j = i; j < numPasseggeri - 1; j++) {
                    passeggeri[j] = passeggeri[j + 1];
                }
                // Nullifica l'ultimo elemento dopo il "shift"
                passeggeri[numPasseggeri - 1] = null;
                numPasseggeri--;
                return;
            }
        }
        System.out.println("Passeggero non trovato");
    }

    public void visualizzaDettagli() {
        System.out.println("Numero Aereo" + numeroAereo);
        System.out.println("Compagnia Aerea" + compagniaAerea);
        System.out.println("Decollo" + decollo);
        System.out.println("Arrivo" + arrivo);
        System.out.println("passeggeri:");
        for (int i = 0; i < numPasseggeri; i++) {
            passeggeri[i].visualizza();
        }
    }
    

    public String getNumeroAereo() {
        return numeroAereo;
    }

    public void setNumeroAereo(String numeroAereo) {
        this.numeroAereo = numeroAereo;
    }

    public String getCompagniaAerea() {
        return compagniaAerea;
    }

    public void setCompagniaAerea(String compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
    }

    public int getMaxPosti() {
        return maxPosti;
    }

    public void setMaxPosti(int maxPosti) {
        this.maxPosti = maxPosti;
    }

    public String getDecollo() {
        return decollo;
    }

    public void setDecollo(String decollo) {
        this.decollo = decollo;
    }

    public String getArrivo() {
        return arrivo;
    }

    public void setArrivo(String arrivo) {
        this.arrivo = arrivo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    public void setNumPasseggeri(int numPasseggeri) {
        this.numPasseggeri = numPasseggeri;
    }

    public Passeggero[] getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(Passeggero[] passeggeri) {
        this.passeggeri = passeggeri;
    }
}




