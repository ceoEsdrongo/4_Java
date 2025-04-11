import javax.swing.*;
import java.awt.*;

public class SemaforoGrafico extends JFrame {

    private final JPanel pannelloVerde = new JPanel();
    private final JPanel pannelloGiallo = new JPanel();
    private final JPanel pannelloRosso = new JPanel();
    private ThreadSemaforoGrafico semaforoThread;

    public SemaforoGrafico() {
        setTitle("Semaforo");
        setSize(200, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        pannelloRosso.setBackground(Color.DARK_GRAY);
        pannelloGiallo.setBackground(Color.DARK_GRAY);
        pannelloVerde.setBackground(Color.DARK_GRAY);

        add(pannelloRosso);
        add(pannelloGiallo);
        add(pannelloVerde);

        setVisible(true);

        // Crea e avvia il thread
        semaforoThread = new ThreadSemaforoGrafico();
        semaforoThread.start();
    }

    public Thread getSemaforoThread() {
        return semaforoThread;
    }

    private class ThreadSemaforoGrafico extends Thread {
        private int cicloCount = 0; // Per tenere traccia dei cicli

        @Override
        public void run() {
            try {
                while (cicloCount < 5) {  // Esegui 5 cicli di semaforo
                    setColor(pannelloVerde, Color.GREEN);
                    setColor(pannelloGiallo, Color.DARK_GRAY);
                    setColor(pannelloRosso, Color.DARK_GRAY);
                    Thread.sleep(3000);

                    setColor(pannelloVerde, Color.DARK_GRAY);
                    setColor(pannelloGiallo, Color.YELLOW);
                    Thread.sleep(1000);

                    setColor(pannelloGiallo, Color.DARK_GRAY);
                    setColor(pannelloRosso, Color.RED);
                    Thread.sleep(4000);

                    cicloCount++;  // Incrementa il contatore dei cicli
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrotto.");
            }
        }

        private void setColor(JPanel panel, Color color) {
            SwingUtilities.invokeLater(() -> panel.setBackground(color));
        }
    }
}
