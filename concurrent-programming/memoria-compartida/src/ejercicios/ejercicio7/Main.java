package ejercicios.ejercicio7;

public class Main {
    public static void main(String[] args) {
        Vehiculo v = new Vehiculo();

        Thread fc = new Thread(new FabricarCarroceria(v));
        Thread fb = new Thread(new FabricarBateria(v));
        Thread fm = new Thread(new FabricarMotor(v));

        fc.start();
        fm.start();
        fb.start();

        try {
            fc.join();
            fm.join();
            fb.join();
        }  catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
