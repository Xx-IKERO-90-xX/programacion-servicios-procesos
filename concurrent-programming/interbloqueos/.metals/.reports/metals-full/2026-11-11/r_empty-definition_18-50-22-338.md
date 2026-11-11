error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/CuentaBancaria.java:_empty_/Random#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/CuentaBancaria.java
empty definition using pc, found symbol in pc: _empty_/Random#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 102
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/CuentaBancaria.java
text:
```scala
package ejercicios.ejercicio1;

public class CuentaBancaria {
    private final int ID = new Random@@().nextInt();
    private double saldo = 1000;

    public synchronized void depositar(double cantidad) {
        this.saldo += cantidad;
    }

    public synchronized void retirar(double cantidad) {
        this.saldo -= cantidad;    
    }

    public synchronized double getSaldo() {
        return saldo;
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Random#