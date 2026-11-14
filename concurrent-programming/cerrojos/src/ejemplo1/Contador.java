package ejemplo1;

import java.util.concurrent.locks.ReentrantLock;

public class Contador {
    private final ReentrantLock lock = new ReentrantLock();
    private int valor = 0;

    public void incrementar() {
        lock.lock();
        try {
            valor++;
            log();
        } finally {
            lock.unlock();
        }
    }

    private void log() {
        lock.lock();
        try {
            System.out.println("Valor actual: " + valor);
        } finally {
            lock.unlock();
        }
    }    
}
