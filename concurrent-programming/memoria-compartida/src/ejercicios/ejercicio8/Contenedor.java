package ejercicios.ejercicio8;

import java.util.ArrayList;
import java.util.List;

public class Contenedor {
    private List<Capsula> listaCapsulas = new ArrayList<>();
    private final int CAPACIDAD_MAXIMA = 100;

    public synchronized void almacenar(Capsula capsula, String nombreProductor) throws InterruptedException {
        while (listaCapsulas.size() >= CAPACIDAD_MAXIMA) {
            wait();
        }

        listaCapsulas.add(capsula);
        System.out.println(nombreProductor + ": Se ha fabricado una cápsula. Total en contenedor: " + listaCapsulas.size());
        
        if (listaCapsulas.size() >= 6) {
            notifyAll();
        }
    }

    public synchronized void extraerCaja() throws InterruptedException {
        while (listaCapsulas.size() < 6) {
            wait();
        }

        System.out.println("Hilo Consumidor: Creando caja con 6 cápsulas");
        for (int i = 0; i < 6; i++) {
            listaCapsulas.remove(0);
        }
        // Mostramos el total remanente inmediatamente de forma atómica
        System.out.println("Hilo Consumidor: Caja creada. Total en contenedor: " + listaCapsulas.size());

        notifyAll();
    }

    public synchronized int getTotal() {
        return listaCapsulas.size();
    }
}
