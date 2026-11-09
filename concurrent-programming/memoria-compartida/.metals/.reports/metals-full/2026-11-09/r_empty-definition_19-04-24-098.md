error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Main.java:java/lang/String#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Main.java
empty definition using pc, found symbol in pc: java/lang/String#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 87
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/ejercicios/ejercicio8/Main.java
text:
```scala
package ejercicios.ejercicio8;

public class Main {
    public static void main(Stri@@ng[] args) {
        Contenedor contenedor = new Contenedor();

        // Creamos el hilo productor con variedad "Arábica" e intensidad 7
        Productor productor = new Productor(contenedor, "Arábica", 7);
        // Creamos el hilo consumidor
        Consumidor consumidor = new Consumidor(contenedor);

        productor.start();
        consumidor.start();
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/String#