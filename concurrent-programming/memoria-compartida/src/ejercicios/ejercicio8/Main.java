package ejercicios.ejercicio8;

public class Main {
    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();

        // Creamos el hilo productor con variedad "Arábica" e intensidad 7
        for (int i = 1; i <= 4; i++) {
            Productor productor = new Productor("Productor-" + i, contenedor, "Arábica", 7);
            productor.start();
        }
        // Creamos el hilo consumidor
        Consumidor consumidor = new Consumidor(contenedor);
        consumidor.start();
    }
}