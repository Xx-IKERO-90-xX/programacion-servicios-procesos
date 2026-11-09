package ejercicios.ejercicio7;

import java.util.Random;

public class FabricarCarroceria implements Runnable {

    private Vehiculo vehiculo;

    public FabricarCarroceria(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        synchronized (vehiculo) {
            System.out.println("FC: Fabricando carrocería");
            try {
                while (vehiculo == null) {
                    System.out.println("FC: Esperando a que se fabrique el vehículo");
                    vehiculo.wait();
                }
                System.out.println("FC: Vehículo fabricado, continuando con la fabricación de la carrocería");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Carroceria c = new Carroceria();
            System.out.println("FC: Carrocería fabricada");
            System.out.println("FC: Ensamblando carrocería");
            try {
                vehiculo.ensamblarCarroceria(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
