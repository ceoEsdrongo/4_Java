/*Implementare una rubrica telefonica con contatti caratterizzati da cognome, nome e numero di
telefono. Si supponga che ogni contatto abbia un solo numero di telefono.
La rubrica deve presentare le seguenti funzionalità:
1. inserimento di un nuovo contatto (controllare che non sia già presente…)
2. eliminazione di un contatto in base al cognome e nome
3. aggiornamento del numero di telefono di un contatto fornito il cognome e nome
4. ricerca del numero di telefono di un contatto in base al cognome e nome
Realizzare un programma principale che permetta di realizzare una rubrica comprensiva delle
funzionalità descritte.
Seconda parte
Risolvere i seguenti punti:
A. realizzare l’inserimento di ogni nuovo contatto in modo da mantenere i contatti in ordine
alfabetico per cognome.
B. aggiungere la possibilità di scegliere dall’input una lettera dell’alfabeto e visualizzare solo
i soli contatti che hanno il cognome che inizia con quella lettera
C. aggiungere la possibilità (molto realistica…) che un contatto abbia più numeri di telefono*/


import java.util.Vector;

public class Gestore {
    private Vector<Contatto> zanfo;

    public Gestore() {
        zanfo = new Vector<>();
    }


    public void aggiungiContatto(Contatto c) {
        int i = 0;
        while (i < zanfo.size() && zanfo.get(i).getCognome().compareToIgnoreCase(c.getCognome()) < 0) {
            i++;
        }
        zanfo.add(i, c);
    }


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


    public boolean aggiornaNumero(String cognome, String nome, double nuovoNumero) {
        for (Contatto c : zanfo) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                c.setNumero(nuovoNumero);
                return true;
            }
        }
        return false;
    }


    public Double cercaNumero(String cognome, String nome) {
        for (Contatto c : zanfo) {
            if (c.getCognome().equalsIgnoreCase(cognome) && c.getNome().equalsIgnoreCase(nome)) {
                return c.getNumero();
            }
        }
        return null;
    }


    public void visualizzaPerLettera(char lettera) {
        for (Contatto c : zanfo) {
            if (c.getCognome().toUpperCase().charAt(0) == Character.toUpperCase(lettera)) {
                c.visualizza();
            }
        }
    }


    public void visualizzaRubrica() {
        for (Contatto c : zanfo) {
            c.visualizza();
        }
    }
}

