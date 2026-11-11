error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/Transferencia.java:_empty_/CuentaBancaria#getPropietario#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/Transferencia.java
empty definition using pc, found symbol in pc: _empty_/CuentaBancaria#getPropietario#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 871
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio1/Transferencia.java
text:
```scala
package ejercicios.ejercicio1;

public class Transferencia {
    public static void transferir(CuentaBancaria origen, CuentaBancaria destino, double cantidad) {
        if (origen.getID() > destino.getID()) {
            CuentaBancaria aux = origen;
            origen = destino;
            destino = aux;
        }

        System.out.println(Thread.currentThread().getName() + " intenta bloquear el inventario de " + origen.getID());
        
        synchronized (origen) {
            System.out.println(Thread.currentThread().getName() + " ha bloqueado la cuenta bancaria de " + origen.getPropietario());
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " intenta bloquear la cuenta bancaria de " + destino.getPropi@@etario());

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

empty definition using pc, found symbol in pc: _empty_/CuentaBancaria#getPropietario#