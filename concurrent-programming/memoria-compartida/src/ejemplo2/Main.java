package ejemplo2;

/**
 * Compartir memoria con Lambda
 * Main
 */
public class Main {
    public static int count = 0;
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    count++;
                }

                System.out.println(
                    "Finalizado el hilo " + Thread.currentThread().getName() + " con count = " + count
                );
            });
            thread.start();
        }
    }
}
