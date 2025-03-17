public class BazajRunnable implements Runnable {
    private String stringa;
    public BazajRunnable(String str) {
        this.stringa = str;
    }
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(stringa);
                Thread.sleep((long) (Math.random() * 1000)); // Pausa casuale fino a 1 secondo
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
