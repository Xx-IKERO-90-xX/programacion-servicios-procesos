error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/cerrojos/src/ejemplo1/Contador.java:java/util/concurrent/locks/ReentrantLock#
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/cerrojos/src/ejemplo1/Contador.java
empty definition using pc, found symbol in pc: java/util/concurrent/locks/ReentrantLock#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 123
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/cerrojos/src/ejemplo1/Contador.java
text:
```scala
package ejemplo1;

import java.util.concurrent.locks.ReentrantLock;

public class Contador {
    private final Reentra@@ntLock lock = new ReentrantLock();
    private int valor = 0;

    public void incrementar() {
        lock.lock();
        try {
            valor++;
            log();
        } finally {
            lock.unlock();
        }
    }

    private void log() {
        lock.lock();
        try {
            System.out.println("Valor actual: " + valor);
        } finally {
            lock.unlock();
        }
    }

    
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/util/concurrent/locks/ReentrantLock#