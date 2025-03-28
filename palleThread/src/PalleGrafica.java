import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Classe che gestisce la finestra e il pannello grafico
class PalleGrafica extends JPanel {
    private final List<PalleThread> palline;

    public PalleGrafica(int numPalline) {
        this.palline = new ArrayList<>();
        setBackground(Color.BLACK);

        Random rand = new Random();
        for (int i = 0; i < numPalline; i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            int diametro = 20 + rand.nextInt(30);
            Color colore = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            PalleThread palla = new PalleThread(x, y, diametro, colore, this);
            palline.add(palla);
            palla.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (PalleThread p : palline) {
            p.disegna(g);
        }
    }
}
