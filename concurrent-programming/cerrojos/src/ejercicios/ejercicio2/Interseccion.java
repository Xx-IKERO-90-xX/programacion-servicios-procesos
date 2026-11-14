package ejercicios.ejercicio2;

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

    @Override
    public void entrar(String unidad) {
        lock.lock();
        try {
            while(!libre) {
                Logger.aviso(nombreInterseccion, unidad + " esperando a que se libere el cruce...");
                puedeEntrar.wait();
            }

            libre = false;
            Logger.info(nombreInterseccion, unidad + " ha entrado en la intersección.");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            libre = true;
            puedeEntrar.signalAll();
            Logger.exito(nombreInterseccion, unidad + " abandona la intersección. Cruce libre.");
            lock.unlock();
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
