package ejercicios.ejercicio3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Interseccion implements Posicion {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition puedeEntrar = lock.newCondition();
    private boolean libre = true;
    private String nombreInterseccion;

    public Interseccion(String nombreInterseccion) {
        this.nombreInterseccion = nombreInterseccion;
    }

    public boolean entrar(String unidad) {
        if (lock.tryLock()) {
            try {
                libre = false;
                Logger.info(nombreInterseccion, unidad + " ha entrado en la intersección.");
                Thread.sleep(3000);
                return true;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                lock.unlock();
                return false;
            }
        } else {
            Logger.aviso(nombreInterseccion, unidad + " intentó entrar pero el crice está ocupado. Debe retroceder.");
            return false;
        }
    }

    @Override
    public void salir(String unidad) {
        lock.lock();
        try {
            libre = true;
            puedeEntrar.signalAll();
            Logger.exito(nombreInterseccion, unidad + " abandona la intersección. Cruce libre.");
        } finally {
            lock.unlock();
        }
    }
}
