import java.awt.*;
import java.util.Random;


class PalleThread extends Thread {
    private int x, y, diametro;
    private int dx, dy;
    private final Color colore;
    private final PalleGrafica pannello;

    public PalleThread(int x, int y, int diametro, Color colore, PalleGrafica pannello) {
        this.x = x;
        this.y = y;
        this.diametro = diametro;
        this.colore = colore;
        this.pannello = pannello;
        Random rand = new Random();
        this.dx = rand.nextInt(5) + 1;
        this.dy = rand.nextInt(5) + 1;
    }

    public void disegna(Graphics g) {
        g.setColor(colore);
        g.fillOval(x, y, diametro, diametro);
    }

    @Override
    public void run() {
        while (true) {
            x += dx;
            y += dy;

            if (x <= 0 || x + diametro >= pannello.getWidth()) dx = -dx;
            if (y <= 0 || y + diametro >= pannello.getHeight()) dy = -dy;

            pannello.repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}