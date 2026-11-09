error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Consumidor.java:_empty_/Contenedor#empaquetar#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Consumidor.java
empty definition using pc, found symbol in pc: _empty_/Contenedor#empaquetar#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 346
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Consumidor.java
text:
```scala
package ejercicios.ejercicio8;

public class Consumidor extends Thread {
    private Contenedor contenedor;

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public void run() {
        try {

            
            while (true) {
                contenedor.empaquetar@@();
            }
        }
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Contenedor#empaquetar#