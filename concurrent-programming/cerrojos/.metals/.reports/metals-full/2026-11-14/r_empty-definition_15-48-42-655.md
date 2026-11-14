error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/cerrojos/src/ejercicios/ejercicio1/Main.java:java/lang/Thread#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/cerrojos/src/ejercicios/ejercicio1/Main.java
empty definition using pc, found symbol in pc: java/lang/Thread#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 569
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/cerrojos/src/ejercicios/ejercicio1/Main.java
text:
```scala
package ejercicios.ejercicio1;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Interseccion i1 = new Interseccion("Int. 1");

        List<Posicion> camino1 = List.of(
            new Recta("Rect. 1"),
            i1,
            new Recta("Rect. 2")
        );

        List<Posicion> camino2 = List.of(
            new Recta("Rect. 3"),
            i1,
            new Recta("Rect. 4")
        );

        new Thread(new Robot("R1", camino1), "Hilo-R1").start();
        new Thre@@ad(new Robot("R2", camino2), "Hilo-R2").start();
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/Thread#