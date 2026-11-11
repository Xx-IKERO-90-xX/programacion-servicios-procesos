package ejercicios.ejercicio1;

import java.util.Random;

public class CuentaBancaria {
    private final int ID = new Random().nextInt();
    private String propietario;
    private double saldo = 1000;

    public CuentaBancaria(String propietario) {
        this.propietario = propietario;
    }

    public synchronized void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public synchronized void retirar(double cantidad) {
        this.saldo -= cantidad;    
    }

    public synchronized int getID() {
        return ID;
    }

    public synchronized String getPropietario() {
        return propietario;
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}
