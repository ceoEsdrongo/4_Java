public class ThreadSemaforo extends Thread {
    int millisecondiverde, millisecondigiallo, millisecondirosso;

    ThreadSemaforo(int millisecondiverde, int millisecondigiallo, int millisecondirosso) {
        this.millisecondiverde = millisecondiverde;
        this.millisecondigiallo = millisecondigiallo;
        this.millisecondirosso = millisecondirosso;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("verde - GAS A MARTELLO");
                Thread.sleep(millisecondiverde);

                System.out.println("giallo - SCALA DUE MARCE");
                Thread.sleep(millisecondigiallo);

                System.out.println("rosso - FRENO E FRIZIONE PREMUTI");
                Thread.sleep(millisecondirosso);

            } catch (InterruptedException e) {
                System.out.println("hai bruciato la frizione " + e);
            }
        }
    }
}