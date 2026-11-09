package ejemplo;

public class App {
    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(counter);
            thread.setName("Hilo " + i);
            thread.start();
        }
    }
}