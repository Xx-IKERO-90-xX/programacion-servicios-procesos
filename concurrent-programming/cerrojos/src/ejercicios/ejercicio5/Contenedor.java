package ejercicios.ejercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Contenedor {
    private List<Capsula> listaCapsulas = new ArrayList<>();
    private final int CAPACIDAD_MAXIMA = 100;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    
    public void almacenar(Capsula capsula, String nombreProductor) throws InterruptedException {
        lock.lock();
        
        try {
            while (listaCapsulas.size() >= CAPACIDAD_MAXIMA) {
                notFull.await();
            }

            listaCapsulas.add(capsula);
            System.out.println(nombreProductor + ": Se ha fabricado una cápsula. Total en contenedor: " + listaCapsulas.size());
            
            if (listaCapsulas.size() >= 6) {
               notEmpty.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void extraerCaja() throws InterruptedException {
        lock.lock();
        try {
            while (listaCapsulas.size() < 6) {
                notFull.await();
            }

            System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");
            for (int i = 0; i < 6; i++) {
                listaCapsulas.remove(0);
            }
            // Mostramos el total remanente inmediatamente de forma atómica
            System.out.println("Hilo Consumidor: Caja creada. Total en contenedor: " + listaCapsulas.size());

            notFull.notifyAll();
        } finally {
            lock.unlock();
        }
    }

    public int getTotal() {
        lock.lock();
        try {
            return listaCapsulas.size();
        } finally {
            lock.unlock();
        }
    }
}
