public class Main {
    public static void main(String[] args) {

        ThreadSemaforo threadSemaforo = new ThreadSemaforo(3000, 1000, 4000);
        threadSemaforo.start(); 


    }
}