public class Aereo {
    private String numeroAereo;
    private int maxPosti;
    private String compagniaAerea;
    private String luogoPartenza;
    private String luogoDestinazione;
    private double costoBase;
    private Passeggero[] passeggeri;
    private int numPasseggeri;  // Contatore per tenere traccia del numero di passeggeri

    // Costruttore
    public Aereo(String numeroAereo, int maxPosti, String compagniaAerea, String luogoPartenza, String luogoDestinazione, double costoBase) {
        this.numeroAereo = numeroAereo;
        this.maxPosti = maxPosti;
        this.compagniaAerea = compagniaAerea;
        this.luogoPartenza = luogoPartenza;
        this.luogoDestinazione = luogoDestinazione;
        this.costoBase = costoBase;
        this.passeggeri = new Passeggero[maxPosti];
        this.numPasseggeri = 0;  // All'inizio non ci sono passeggeri
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

    // Metodo per rimuovere un passeggero specifico
    public void rimuoviPasseggero(String nome, String cognome) {
        for (int i = 0; i < numPasseggeri; i++) {
            if (passeggeri[i].getNome().equalsIgnoreCase(nome) && passeggeri[i].getCognome().equalsIgnoreCase(cognome)) {
                // Shift dei passeggeri per riempire il "buco"
                for (int j = i; j < numPasseggeri - 1; j++) {
                    passeggeri[j] = passeggeri[j + 1];
                }
                passeggeri[numPasseggeri - 1] = null; // Elimina l'ultimo elemento
                numPasseggeri--; // Diminuisce il numero dei passeggeri
                System.out.println("Passeggero rimosso.");
                return;
            }
        }
        System.out.println("Passeggero non trovato.");
    }

    // Metodo per visualizzare le informazioni dell'aereo e dei passeggeri
    public void visualizzaDettagli() {
        System.out.println("Numero Aereo: " + numeroAereo);
        System.out.println("Compagnia Aerea: " + compagniaAerea);
        System.out.println("Luogo di Partenza: " + luogoPartenza);
        System.out.println("Luogo di Destinazione: " + luogoDestinazione);
        System.out.println("Passeggeri:");
        for (int i = 0; i < numPasseggeri; i++) {
            passeggeri[i].visualizzaDettagli();
        }
    }

    // Metodo per calcolare il peso totale dei bagagli
    public double calcolaPesoTotaleBagagli() {
        double pesoTotale = 0;
        for (int i = 0; i < numPasseggeri; i++) {
            pesoTotale += passeggeri[i].getPesoBagaglioMano() + passeggeri[i].getPesoBagaglioStiva();
        }
        return pesoTotale;
    }

    // Metodo per visualizzare il passeggero che ha pagato di più
    public void visualizzaPasseggeroCheHaPagatoDiPiu() {
        Passeggero piuCostoso = null;
        for (int i = 0; i < numPasseggeri; i++) {
            if (piuCostoso == null || passeggeri[i].getCostoTotaleBiglietto() > piuCostoso.getCostoTotaleBiglietto()) {
                piuCostoso = passeggeri[i];
            }
        }
        if (piuCostoso != null) {
            System.out.println("Il passeggero che ha pagato di più è:");
            piuCostoso.visualizzaDettagli();
        }
    }

    // Getter e Setter
    public String getNumeroAereo() {
        return numeroAereo;
    }

    public void setNumeroAereo(String numeroAereo) {
        this.numeroAereo = numeroAereo;
    }

    public int getMaxPosti() {
        return maxPosti;
    }

    public void setMaxPosti(int maxPosti) {
        this.maxPosti = maxPosti;
    }

    public String getCompagniaAerea() {
        return compagniaAerea;
    }

    public void setCompagniaAerea(String compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
    }

    public String getLuogoPartenza() {
        return luogoPartenza;
    }

    public void setLuogoPartenza(String luogoPartenza) {
        this.luogoPartenza = luogoPartenza;
    }

    public String getLuogoDestinazione() {
        return luogoDestinazione;
    }

    public void setLuogoDestinazione(String luogoDestinazione) {
        this.luogoDestinazione = luogoDestinazione;
    }

    public Passeggero[] getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(Passeggero[] passeggeri) {
        this.passeggeri = passeggeri;
    }
}
