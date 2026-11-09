package ejercicios.ejercicio7;

import java.util.Random;

public class FabricarBateria implements Runnable {

    private Vehiculo vehiculo = null;

    public FabricarBateria(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        synchronized (vehiculo){
            System.out.println("FB: Fabricando batería");
            try {
                while (vehiculo == null) {
                    System.out.println("FB: Esperando a que se fabrique la carrocería");
                    vehiculo.wait();
                }
                System.out.println("FB: Carrocería fabricada, continuando con la fabricación de la batería");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("FB: Batería fabricada");
            System.out.println("FB: Ensamblando batería");
        }
    }
}
