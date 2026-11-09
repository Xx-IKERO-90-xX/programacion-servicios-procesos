error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/suspension-finalizacion/exercises-2/src/exercises/exercise4/MaintGameCount.java:java/lang/System#out#println#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/suspension-finalizacion/exercises-2/src/exercises/exercise4/MaintGameCount.java
empty definition using pc, found symbol in pc: java/lang/System#out#println#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 199
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/suspension-finalizacion/exercises-2/src/exercises/exercise4/MaintGameCount.java
text:
```scala
package exercises.exercise4;

import java.util.Random;

public class MaintGameCount {
    Random random = new Random();

    int numObjectives = random.nextInt(11) + 10;
    
    System.out.@@println("=========================================");
        System.out.println("       JUEGO: DETÉN EL CONTADOR          ");
        System.out.println("=========================================");
        System.out.println("- El contador empezará a contar desde 1.");
        System.out.println("- Solo verás los primeros 5 números.");
        System.out.println("- Debes pulsar la tecla **ENTER** cuando");
        System.out.println("  creas que ha llegado al número secreto.");
        System.out.println("=========================================\n");

        System.out.println("¡El contador arranca ya! Prepárate...");
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/System#out#println#