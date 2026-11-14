package ejercicios.ejercicio5;

import java.util.Random;

public class Productor extends Thread {
    private Contenedor contenedor;
    private String variedad;
    private int intensidad;
    private Random random = new Random();

    public Productor(String nombre, Contenedor contenedor, String variedad, int intensidad) {
        super(nombre);
        this.contenedor = contenedor;
        this.variedad = variedad;
        this.intensidad = intensidad;
    }  

    @Override
    public void run() {
        try {
            while (true) {
                int time = random.nextInt(501) + 500;
                Thread.sleep(time);

                Capsula capsula = new Capsula(variedad, intensidad);
                contenedor.almacenar(capsula, getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
