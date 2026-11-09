package recursoscompartidos.ejemplo2;

public class HiloReintegro implements Runnable {
    private Cuenta cuenta;
    private Perro dog;

    public HiloReintegro(Cuenta cuenta, Perro dog) {
        this.cuenta = cuenta;
        this.dog = dog;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            synchronized (dog) {
                try {
                    System.out.println("No hay saldo suficiente, esperando ingreso de dinero...");
                    cuenta.wait();
                    System.out.println("Ya se ha producido un ingreso.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cuenta.retirar(100);
            }
        }
    }
}
