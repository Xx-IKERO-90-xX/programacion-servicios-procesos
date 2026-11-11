error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/Transferencia.java:_empty_/CuentaBancaria#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/Transferencia.java
empty definition using pc, found symbol in pc: _empty_/CuentaBancaria#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 131
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/Transferencia.java
text:
```scala
package ejercicios.ejercicio1;

public class Transferencia {
    public static void transferir(CuentaBancaria origen, CuentaBanc@@aria destino, double cantidad) {
        
        
        synchronized (origen) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}

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

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/CuentaBancaria#