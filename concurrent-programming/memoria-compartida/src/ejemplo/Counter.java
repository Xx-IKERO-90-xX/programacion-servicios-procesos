package ejemplo;

public class Counter implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            count++;
        }
        System.out.println(
            "Finalizado el hilo " + Thread.currentThread().getName() + " con count = " + count
        );
    }

}
