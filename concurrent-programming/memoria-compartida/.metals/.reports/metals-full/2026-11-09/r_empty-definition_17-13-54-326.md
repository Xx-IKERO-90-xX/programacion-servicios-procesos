error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio7/FabricarCarroceria.java:java/lang/System#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio7/FabricarCarroceria.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 316
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio7/FabricarCarroceria.java
text:
```scala
package ejercicios.ejercicio7;

import java.util.Random;

public class FabricarCarroceria implements Runnable {

    private Vehiculo vehiculo;

    public FabricarCarroceria(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        Random r = new Random();
        s@@
        Carroceria c = new Carroceria();
        System.out.println("FC: Carrocería fabricada");

        System.out.println("FM: Ensamblando carrocería");
        vehiculo.ensamblarCarroceria(c);
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 