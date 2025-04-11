import javax.swing.*;
import java.awt.*;
public class SemaforoGrafico extends JFrame {

    private final JPanel pannelloVerde = new JPanel();
    private final JPanel pannelloGiallo = new JPanel();
    private final JPanel pannelloRosso = new JPanel();

    public SemaforoGrafico() {
        setTitle("Semaforo");
        setSize(200, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        pannelloRosso.setBackground(Color.WHITE);
        pannelloGiallo.setBackground(Color.WHITE);
        pannelloVerde.setBackground(Color.WHITE);

        add(pannelloRosso);
        add(pannelloGiallo);
        add(pannelloVerde);

        setVisible(true);

        // Avvio del thread
        new ThreadSemaforoGrafico().start();
    }

    private class ThreadSemaforoGrafico extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    // Verde
                    setColor(pannelloVerde, Color.GREEN);
                    setColor(pannelloGiallo, Color.WHITE);
                    setColor(pannelloRosso, Color.WHITE);
                    Thread.sleep(3000);

                    // Giallo
                    setColor(pannelloVerde, Color.WHITE);
                    setColor(pannelloGiallo, Color.YELLOW);
                    Thread.sleep(1000);

                    // Rosso
                    setColor(pannelloGiallo, Color.WHITE);
                    setColor(pannelloRosso, Color.RED);
                    Thread.sleep(4000);

                } catch (InterruptedException e) {
                    System.out.println("Errore: " + e.getMessage());
                }
            }
        }

        private void setColor(JPanel panel, Color color) {
            SwingUtilities.invokeLater(() -> panel.setBackground(color));//colore di sfondo di un pannello
        }
    }
}