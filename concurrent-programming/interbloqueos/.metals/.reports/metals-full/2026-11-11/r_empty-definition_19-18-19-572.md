error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio3/Main.java:java/lang/System#out.
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio3/Main.java
empty definition using pc, found symbol in pc: java/lang/System#out.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 658
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/interbloqueos/src/ejercicios/ejercicio3/Main.java
text:
```scala
package ejercicios.ejercicio3;

public class Main {
    private static final Object pizarra = new Object();
    private static final Object rotulador = new Object();
    public static void main(String[] args) {
        new Thread(Main::ejecutarTrabajoProgramador1).start();
        new Thread(Main::ejecutarTrabajoProgramador2).start();
    }
    public static void ejecutarTrabajoProgramador1() {
        synchronized (pizarra) {
        System.out.println("Prog 1 tiene la pizarra. Esperando rotulador...");
            try { Thread.sleep(50); } catch (InterruptedException e) {}
            synchronized (rotulador) {
                System.@@out.println("Prog 1 está diseñando.");
            }
        }
    }
    public static void ejecutarTrabajoProgramador2() {
    synchronized (rotulador) {
    System.out.println("Prog 2 tiene el rotulador. Esperando pizarra...");
    try { Thread.sleep(50); } catch (InterruptedException e) {}
    synchronized (pizarra) {
    System.out.println("Prog 2 está diseñando.");
    }
    }
}}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/System#out.