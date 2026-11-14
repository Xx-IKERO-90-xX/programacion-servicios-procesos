package ejercicios.ejercicio4;

import java.util.concurrent.locks.ReentrantLock;

public class Impresora {
    private final ReentrantLock lock = new ReentrantLock();

    public void imprimirDocumento(String documento) {
        lock.lock();
        try {
            System.out.println("Imprimiendo: " + documento);

            if (documento == null) {
                throw new IllegalArgumentException("El documento no debe ser nulo");
            }

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
