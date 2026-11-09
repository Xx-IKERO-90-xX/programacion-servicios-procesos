error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio7/FabricarBateria.java:java/io/PrintStream#println(+8).
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio7/FabricarBateria.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 688
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio7/FabricarBateria.java
text:
```scala
package ejercicios.ejercicio7;

import java.util.Random;

public class FabricarBateria implements Runnable {

    private Vehiculo vehiculo;

    public FabricarBateria(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        Random r = new Random();
        System.out.println("FB: Fabricando batería");
        try {
            Thread.sleep(r.nextInt(1000,2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bateria b = new Bateria();
        System.out.println("FB: Batería fabricada");

        synchronized (vehiculo){
            Random r = new Random();
        System.out.println@@("FB: Fabricando batería");
        try {
            Thread.sleep(r.nextInt(1000,2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Bateria b = new Bateria();
        System.out.println("FB: Batería fabricada");


            System.out.println("FB: Ensamblando batería");
            vehiculo.ensamblarBateria(b);
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).