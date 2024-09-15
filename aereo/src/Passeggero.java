public class Passeggero {
    private String cognome;
    private String nome;
    private double pesoBagaglioMano;
    private double pesoBagaglioStiva;
    private double costoBaseBiglietto;
    private double costoBagagli;

    // Costruttore
    public Passeggero(String cognome, String nome, double pesoBagaglioMano, double pesoBagaglioStiva, double costoBaseBiglietto) {
        this.cognome = cognome;
        this.nome = nome;
        this.pesoBagaglioMano = pesoBagaglioMano;
        this.pesoBagaglioStiva = pesoBagaglioStiva;
        this.costoBaseBiglietto = costoBaseBiglietto;
        this.costoBagagli = calcolaCostoBagagli();
    }

    // Metodo per calcolare il costo dei bagagli
    private double calcolaCostoBagagli() {
        double costoTotale = 0;

        // Calcolo per il bagaglio a mano
        if (pesoBagaglioMano <= 10) {
            costoTotale += 10;
        } else {
            costoTotale += 10 + (pesoBagaglioMano - 10) * 2;
        }

        // Calcolo per il bagaglio in stiva
        if (pesoBagaglioStiva <= 20) {
            costoTotale += 30;
        } else {
            costoTotale += 30 + (pesoBagaglioStiva - 20) * 5;
        }

        return costoTotale;
    }

    // Getter e Setter
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPesoBagaglioMano() {
        return pesoBagaglioMano;
    }

    public void setPesoBagaglioMano(double pesoBagaglioMano) {
        this.pesoBagaglioMano = pesoBagaglioMano;
    }

    public double getPesoBagaglioStiva() {
        return pesoBagaglioStiva;
    }

    public void setPesoBagaglioStiva(double pesoBagaglioStiva) {
        this.pesoBagaglioStiva = pesoBagaglioStiva;
    }

    public double getCostoBaseBiglietto() {
        return costoBaseBiglietto;
    }

    public void setCostoBaseBiglietto(double costoBaseBiglietto) {
        this.costoBaseBiglietto = costoBaseBiglietto;
    }

    public double getCostoBagagli() {
        return costoBagagli;
    }

    public double getCostoTotaleBiglietto() {
        return costoBaseBiglietto + costoBagagli;
    }

    // Metodo per visualizzare le informazioni del passeggero
    public void visualizzaDettagli() {
        System.out.println("Nome: " + nome + " " + cognome);
        System.out.println("Costo totale biglietto: €" + getCostoTotaleBiglietto());
    }
}
