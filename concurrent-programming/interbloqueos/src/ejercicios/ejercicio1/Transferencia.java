package ejercicios.ejercicio1;

public class Transferencia {
    public static void transferir(CuentaBancaria origen, CuentaBancaria destino, double cantidad) {
        if (origen.getID() > destino.getID()) {
            CuentaBancaria aux = origen;
            origen = destino;
            destino = aux;
        }

        System.out.println(Thread.currentThread().getName() + " intenta bloquear el inventario de " + origen.getPropietario());
        
        synchronized (origen) {
            System.out.println(Thread.currentThread().getName() + " ha bloqueado la cuenta bancaria de " + origen.getPropietario());
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " intenta bloquear la cuenta bancaria de " + destino.getPropietario());

            synchronized (destino) {
                if (origen.getSaldo() >= cantidad) {
                    origen.retirar(cantidad);
                    destino.depositar(cantidad);
                    System.out.println("Transferencia realizada con éxito.");
                }
            }
        }
    }
}
