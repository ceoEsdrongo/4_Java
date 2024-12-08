import java.util.Vector;

/*Esercizio-3
In file ad oggetti utenti.dat sono memorizzate le credenziali di accesso (nome utente e
password) degli utenti che utilizzano un software di contabilità.
Realizzare un programma che permetta l’accesso al software controllando se le
credenziali inserite dall’input dall’utente sono corrette.
*/
public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.inserimento();
        admin.mostraUtentiSalvati();
    }
}