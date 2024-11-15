import java.util.Vector;

public class Gestore {
    private Vector<Contatto> zanfo;

    public Gestore() {
        zanfo = new Vector<>();
    }

    // Aggiungi contatto e mantieni l'ordine alfabetico
    public void aggiungiContatto(Contatto c) {
        int i = 0;
        while (i < zanfo.size() && zanfo.get(i).getCognome().compareToIgnoreCase(c.getCognome()) < 0) {
            i++;
        }
        zanfo.add(i, c);
    }

    // Elimina un contatto dato il cognome e il nome
    public boolean eliminaContatto(String cognome, String nome) {
        for (int i = 0; i < zanfo.size(); i++) {
            Contatto c = zanfo.get(i);
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                zanfo.remove(i);
                return true;
            }
        }
        return false;
    }

    // Aggiorna il numero di telefono di un contatto
    public boolean aggiornaNumero(String cognome, String nome, double nuovoNumero) {
        for (Contatto c : zanfo) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(nuovoNumero);
                return true;
            }
        }
        return false;
    }

    // Cerca il numero di telefono di un contatto
    public Double cercaNumero(String cognome, String nome) {
        for (Contatto c : zanfo) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                return c.getNumero();
            }
        }
        return null;
    }

    // Visualizza i contatti che iniziano con una lettera
    public void visualizzaPerLettera(char lettera) {
        for (Contatto c : zanfo) {
            if (c.getCognome().toUpperCase().charAt(0) == Character.toUpperCase(lettera)) {
                c.visualizza();
            }
        }
    }

    // Visualizza tutti i contatti
    public void visualizzaRubrica() {
        for (Contatto c : zanfo) {
            c.visualizza();
        }
    }
}
