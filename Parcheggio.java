import java.util.*;
import java.util.concurrent.*;

class Parcheggio {
    private final int postiDisponibili;
    private final Semaphore posti;
    private final Queue<Auto> coda = new ConcurrentLinkedQueue<>();

    public Parcheggio(int postiDisponibili) {
        this.postiDisponibili = postiDisponibili;
        this.posti = new Semaphore(postiDisponibili, true);
    }

    public void entra(Auto auto) throws InterruptedException {
        if (posti.tryAcquire()) {
            System.out.println(auto.getNome() + " è entrata nel parcheggio.");
            auto.parcheggia();
            posti.release();
            System.out.println(auto.getNome() + " ha lasciato il parcheggio.");
        } else {
            System.out.println(auto.getNome() + " è in coda.");
            coda.add(auto);
        }
    }

    public void controllaCoda() {
        if (!coda.isEmpty() && posti.tryAcquire()) {
            Auto auto = coda.poll();
            if (auto != null) {
                new Thread(() -> {
                    try {
                        System.out.println(auto.getNome() + " è entrata dal fondo della coda.");
                        auto.parcheggia();
                        posti.release();
                        System.out.println(auto.getNome() + " ha lasciato il parcheggio.");
                    } catch (InterruptedException e) {
                        System.out.println(auto.getNome() + " è stata interrotta.");
                    }
                }).start();
            }
        }
    }

    public void rimuoviAutoRandom() {
        if (!coda.isEmpty() && new Random().nextBoolean()) {
            Auto rimossa = coda.poll();
            if (rimossa != null) {
                System.out.println(rimossa.getNome() + " si è stufata e se n'è andata.");
            }
        }
    }
}
