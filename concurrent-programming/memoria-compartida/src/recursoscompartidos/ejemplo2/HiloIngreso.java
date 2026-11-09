package recursoscompartidos.ejemplo2;

public class HiloIngreso implements Runnable {
    private Cuenta cuenta;
    private Perro dog;

    public HiloIngreso(Cuenta cuenta, Perro dog) {
        this.cuenta = cuenta;
        this.dog = dog;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            synchronized (dog) {
                cuenta.ingresar(100);
                System.out.println("INGRESO. Saldo: " + cuenta.getSaldo());
                cuenta.notify();
            }
        }
    }
}
