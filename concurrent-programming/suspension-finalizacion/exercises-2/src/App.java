import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        /* 
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            */
        
        Thread t = new Thread(() -> {
            try {
                Random r = new Random();
                for (int i = 0; i < 10; i++) {
                    Thread.sleep((long)r.nextInt(1500));
                    System.out.println("Numero " + i);
                }
            } catch (InterruptedException ie) {
                System.out.println("El hilo a sido interrumpido.");
            }
        });
        t.start();
        t.join();

        System.out.println("El hilo ha finalizado.");
    }
}
