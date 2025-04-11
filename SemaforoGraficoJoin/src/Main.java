public class Main {
    public static void main(String[] args) {
        // Crea la finestra del semaforo
        SemaforoGrafico finestra = new SemaforoGrafico();

        try {
            
            finestra.getSemaforoThread().join();
        } catch (InterruptedException e) {
            System.out.println("Main interrotto durante il join.");
        }

        System.out.println("Il thread è terminato. Fine programma.");
    }
}
