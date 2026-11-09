package recursoscompartidos.ejemplo1;

public class Main {
    public static void main(String[] args) throws Exception {
        Cuenta cuenta = new Cuenta();

        // Creamos 2 hilos, uno que va a ingresar dinero en la cuenta y otro para retirar.
        HiloIngreso hiloIngreso = new HiloIngreso(cuenta);
        HiloReintegro hiloReintegro = new HiloReintegro(cuenta);

        Thread t1 = new Thread(hiloIngreso);
        Thread t2 = new Thread(hiloReintegro);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}
