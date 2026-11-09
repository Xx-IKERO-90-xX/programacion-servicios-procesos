package ejercicios.ejercicio8;

import java.util.Random;

public class Consumidor extends Thread {
    private Contenedor contenedor;
    private Random random = new Random();

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
    try {
        while (true) {
            // 1. Retira las 6 cápsulas del contenedor
            contenedor.extraerCaja();

            // 2. Simula el tiempo de empaquetado (1000 a 3000 ms) fuera del bloque sincronizado
            int tiempoEmpaquetado = random.nextInt(2001) + 1000;
            Thread.sleep(tiempoEmpaquetado);

            /*  3. Imprime la confirmación y las cápsulas restantes
            System.out.println("Hilo Consumidor: Caja creada");
            System.out.println("Total en contenedor: " + contenedor.getTotal());*/
        }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}