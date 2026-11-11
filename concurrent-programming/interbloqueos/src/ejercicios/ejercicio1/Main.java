package ejercicios.ejercicio1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cb1 = new CuentaBancaria("Ana");
        CuentaBancaria cb2 = new CuentaBancaria("Bernat");
        Transferencia transferencia = new Transferencia();

        Thread hilo1 = new Thread(
            () -> transferencia.transferir(cb1, cb2, 20), "Hilo1-CuentaBancaria1->CuentaBancaria2"
        );
        Thread hilo2 = new Thread(
            () -> transferencia.transferir(cb2, cb1, 20), "Hilo2-CuentaBancaria2->CuentaBancaria1"
        );

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Transferencias finalizadas!");
    }
}
