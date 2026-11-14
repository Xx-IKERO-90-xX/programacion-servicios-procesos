package ejemplo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Piscina {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition puedeNadar = lock.newCondition();
    private final Condition puedeSaltar = lock.newCondition();

    private boolean turnoDeSaltar = false;

    public void nadar(String nombre) throws InterruptedException {
        lock.lock();
        try {
            while (turnoDeSaltar) {
                System.out.println(nombre + " espera a que termine el turno de saltar...");
                puedeNadar.await();
            }
            System.out.println(nombre + " esta nadando tranquilamente");
        } finally {
            lock.unlock();
        }
    }

    public void saltar(String nombre) throws InterruptedException {
        lock.lock();
        try {
            while (!turnoDeSaltar) {
                System.out.println(nombre + " espera a que termine el turno de natación...");
                puedeSaltar.await();
            }
            System.out.println(nombre + " salta desde el trampolin. Splash!");
        } finally {
            lock.unlock();
        }
    }

    public void cambiarTurno() {
        lock.lock();
        try {
            turnoDeSaltar = !turnoDeSaltar;
            if (turnoDeSaltar) {
                System.out.println("El socorrinta anuncia: Turno de saltar!");
                puedeSaltar.signalAll();
            } else {
                System.out.println("El socorrista anuncia: Turno de Natación!");
                puedeNadar.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}
