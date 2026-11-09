package exercises;

import java.util.Random;
import java.util.Scanner;

class CountTask implements Runnable {
    private volatile boolean activo = true;
    private int counter = 0;

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000); // Espera de 1 segundo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            if (activo) {
                counter++;
                // Muestra los números por pantalla solo hasta el 5 inclusive
                if (counter <= 5) {
                    System.out.println("Contador: " + counter);
                }
            }
        }
    }

    public void stop() {
        this.activo = false;
    }

    public int getCount() {
        return counter;
    }
}

public class exercise4 {
    public static void main(String[] args) {
        Random random = new Random();
            
            // Genera un número aleatorio entre 10 y 20 inclusive (20 - 10 + 1 = 11)
        int numeroObjetivo = random.nextInt(11) + 10;

        System.out.println("=========================================");
        System.out.println("       JUEGO: DETÉN EL CONTADOR          ");
        System.out.println("=========================================");
        System.out.println("- El contador empezará a contar desde 1.");
        System.out.println("- Solo verás los primeros 5 números.");
        System.out.println("- Debes pulsar la tecla **ENTER** cuando");
        System.out.println("  creas que ha llegado al número secreto.");
        System.out.println("=========================================\n");

        System.out.println("¡El contador arranca ya! Prepárate...");

            // Creamos la tarea y lanzamos el hilo
        CountTask task = new CountTask();
        Thread hilo = new Thread(task);
        hilo.start();

            // El programa principal espera a que el usuario pulse ENTER
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); 

            // El usuario pulsó ENTER, detenemos el hilo mediante el flag y una interrupción
        task.stop();
        hilo.interrupt(); // Rompe el Thread.sleep() actual para que la respuesta sea inmediata

        scanner.close();

        try {
                // Esperamos a que el hilo termine de morir completamente
            hilo.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

            // Mostramos el resultado final
        int numeroFinal = task.getCount();
        System.out.println("\n-----------------------------------------");
        System.out.println("           RESULTADO FINAL               ");
        System.out.println("-----------------------------------------");
        System.out.println("Número secreto:        " + numeroObjetivo);
        System.out.println("Tu contador se detuvo en: " + numeroFinal);

        if (numeroFinal == numeroObjetivo) {
            System.out.println("¡Impresionante! ¡Has ganado el juego!");
        } else {
            int diferencia = Math.abs(numeroFinal - numeroObjetivo);
            System.out.println("¡Casi! Te has desviado por " + diferencia + " unidad(es).");
        }
        System.out.println("-----------------------------------------");
    }
}
