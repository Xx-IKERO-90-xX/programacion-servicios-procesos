error id: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/recursoscompartidos/ejemplo1/Cuenta.java:
file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/recursoscompartidos/ejemplo1/Cuenta.java
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 107
uri: file:///C:/Users/Ikero/Desktop/programación-servicios-procesos/concurrent-programming/memoria-compartida/src/recursoscompartidos/ejemplo1/Cuenta.java
text:
```scala
package recursoscompartidos.ejemplo1;

public class Cuenta {
    private double saldo = 0;

    public@@ double getSaldo() {return saldo;}

    public void ingresar(double cantidad) {saldo += cantidad;}

    public void retirar(double cantidad) {saldo -= cantidad;}
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: 