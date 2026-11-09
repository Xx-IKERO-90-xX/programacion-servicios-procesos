error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/recursoscompartidos/ejemplo2/Main.java:java/lang/Thread#join(+2).
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/recursoscompartidos/ejemplo2/Main.java
empty definition using pc, found symbol in pc: java/lang/Thread#join(+2).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 603
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/recursoscompartidos/ejemplo2/Main.java
text:
```scala
package recursoscompartidos.ejemplo2;

public class Main {
    public static void main(String[] args) throws Exception {
        Cuenta cuenta = new Cuenta();
        Perro dog = new Perro();

        // Creamos 2 hilos, uno que va a ingresar dinero en la cuenta y otro para retirar.
        HiloIngreso hiloIngreso = new HiloIngreso(cuenta, dog);
        HiloReintegro hiloReintegro = new HiloReintegro(cuenta, dog);

        Thread t1 = new Thread(hiloIngreso);
        Thread t2 = new Thread(hiloReintegro);

        t1.start();
        t2.start();

        try {
            t1.joi@@n();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo final: " + cuenta.getSaldo());
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Thread#join(+2).