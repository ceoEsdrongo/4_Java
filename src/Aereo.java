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
            if (passeggeroCheHaPagatoDiPiu == null || passeggeri[i].getCostoBiglietto()> passeggeroCheHaPagatoDiPiu.getCostoBiglietto()) {
                passeggeroCheHaPagatoDiPiu = passeggeri[i];
            }
        }
        if (passeggeroCheHaPagatoDiPiu != null) {
            System.out.println("Il passeggero che ha pagato di più è:");
            passeggeroCheHaPagatoDiPiu.visualizza();
        }
    }
}