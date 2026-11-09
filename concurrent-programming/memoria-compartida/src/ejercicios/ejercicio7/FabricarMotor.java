package ejercicios.ejercicio7;

import java.util.Random;

public class FabricarMotor implements Runnable {

    private Vehiculo vehiculo;

    public FabricarMotor(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        synchronized (vehiculo) {
            System.out.println("FM: Fabricando motor.");
            try {
                while (vehiculo == null) {
                    System.out.println("FM: Esperando a que se fabrique el vehículo");
                    vehiculo.wait();
                }
                System.out.println("FM: Motor fabricada, continuando con la fabricación del motor.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Motor m = new Motor();
            System.out.println("FM: Motor fabricado");

            System.out.println("FM: Ensamblando motor");
            try {
                vehiculo.ensamblarMotor(m);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
