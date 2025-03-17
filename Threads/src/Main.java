public class Main {
    public static void main(String[] args) {
        /*Realizzare un semplice programma (modalità testo) che permetta di visualizzare il proprio nome e cognome
        utilizzando rispettivamente due thread (un thread per il nome e un thread per il cognome). Ogni thread visualizza la propria
        stringa continuamente ma con pause casuali di massimo 1 secondo.
        Realizzare il programma…
        estendendo la classe Thread
        implementando l’interfaccia Runnable*/

        ThreadBazaj nomeThread = new ThreadBazaj("Angelo");
        ThreadBazaj cognomeThread = new ThreadBazaj("Lideo");

        nomeThread.start();
        cognomeThread.start();
    }
}