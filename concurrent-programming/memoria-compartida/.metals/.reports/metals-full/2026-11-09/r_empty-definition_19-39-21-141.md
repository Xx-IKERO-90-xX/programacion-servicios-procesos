error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Productor.java:ejercicios/ejercicio8/Productor#variedad.
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Productor.java
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol ejercicios/ejercicio8/Productor#variedad.
empty definition using fallback
non-local guesses:

offset: 422
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Productor.java
text:
```scala
package ejercicios.ejercicio8;

import java.util.Random;

public class Productor extends Thread {
    private Contenedor contenedor;
    private String variedad;
    private int intensidad;
    private Random random = new Random();

    public Productor(String nombre, Contenedor contenedor, String variedad, int intensidad) {
        super(nombre);
        this.contenedor = contenedor;
        this.variedad@@ = variedad;
        this.intensidad = intensidad;
    }  

    @Override
    public void run() {
        try {
            while (true) {
                int time = random.nextInt(501) + 500;
                Thread.sleep(time);

                Capsula capsula = new Capsula(variedad, intensidad);
                contenedor.almacenar(capsula, getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 