import java.util.ArrayList;

public class Aereo {
    private String numeroAereo;
    private int maxPosti;
    private String compagniaAerea;
    private String luogoPartenza;
    private String luogoDestinazione;
    private double costoBase;
    private ArrayList<Passeggero> passeggeri;

    // Costruttore
    public Aereo(String numeroAereo, int maxPosti, String compagniaAerea, String luogoPartenza, String luogoDestinazione, double costoBase) {
        this.numeroAereo = numeroAereo;
        this.maxPosti = maxPosti;
        this.compagniaAerea = compagniaAerea;
        this.luogoPartenza = luogoPartenza;
        this.luogoDestinazione = luogoDestinazione;
        this.costoBase = costoBase;
        this.passeggeri = new ArrayList<>();
    }

    // Metodo per aggiungere un passeggero
    public void aggiungiPasseggero(Passeggero passeggero) {
        if (passeggeri.size() < maxPosti) {
            passeggeri.add(passeggero);
        } else {
            System.out.println("Aereo al completo, non è possibile aggiungere altri passeggeri.");
        }
    }

    // Metodo per rimuovere un passeggero specifico
    public void rimuoviPasseggero(String nome, String cognome) {
        passeggeri.removeIf(p -> p.getNome().equalsIgnoreCase(nome) && p.getCognome().equalsIgnoreCase(cognome));
    }

    // Metodo per visualizzare le informazioni dell'aereo e dei passeggeri
    public void visualizzaDettagli() {
        System.out.println("Numero Aereo: " + numeroAereo);
        System.out.println("Compagnia Aerea: " + compagniaAerea);
        System.out.println("Luogo di Partenza: " + luogoPartenza);
        System.out.println("Luogo di Destinazione: " + luogoDestinazione);
        System.out.println("Passeggeri:");
        for (Passeggero p : passeggeri) {
            p.visualizzaDettagli();
        }
    }

    // Metodo per calcolare il peso totale dei bagagli
    public double calcolaPesoTotaleBagagli() {
        double pesoTotale = 0;
        for (Passeggero p : passeggeri) {
            pesoTotale += p.getPesoBagaglioMano() + p.getPesoBagaglioStiva();
        }
        return pesoTotale;
    }

    // Metodo per visualizzare il passeggero che ha pagato di più
    public void visualizzaPasseggeroCheHaPagatoDiPiu() {
        Passeggero piuCostoso = null;
        for (Passeggero p : passeggeri) {
            if (piuCostoso == null || p.getCostoTotaleBiglietto() > piuCostoso.getCostoTotaleBiglietto()) {
                piuCostoso = p;
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

    public ArrayList<Passeggero> getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(ArrayList<Passeggero> passeggeri) {
        this.passeggeri = passeggeri;
    }
}
