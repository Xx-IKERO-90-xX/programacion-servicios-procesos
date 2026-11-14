package ejemplo2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Piscina piscina = new Piscina();

        Thread[] nadadores = new Thread[3];
        for (int i = 0; i < nadadores.length; i++) {
            nadadores[i] = new Thread(new Nadador(piscina, "Nadador-" + i));
        }

        Thread[] saltadores = new Thread[3];
        for (int i = 0; i < saltadores.length; i++) {
            nadadores[i] = new Thread(new Nadador(piscina, "Saltador-" + i));
        }

        Thread socorrista = new Thread(new Socorrista(piscina, 4, 1000));

        for (Thread t : nadadores) t.start();
        for (Thread t : saltadores) t.start();
        socorrista.start();

        for (Thread t : nadadores) t.join();
        for (Thread t : saltadores) t.join();
        socorrista.start();



    }
    
}
