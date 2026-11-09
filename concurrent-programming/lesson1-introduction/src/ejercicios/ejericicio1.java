package ejercicios;

import java.util.Scanner;
import java.util.Random;

class RangoTask implements Runnable {
    private int n1;
    private int n2;

    public RangoTask(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @Override
    public void run() {
        int start = Math.min(n1, n2);
        int end = Math.max(n1, n2);
        Random random = new Random();

        for (int i = start; i < end; i++) {
            System.out.println("Número: " + i);
            try {
                // Suspende el hilo entre 1 y 1000 milisegundos
                Thread.sleep(random.nextInt(1000) + 1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El hilo fue interrumpido.");
            }
        }

    }
    
}

public class ejericicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número n1: ");
        int n1 = scanner.nextInt();

        System.out.print("Introduce el número n2: ");
        int n2 = scanner.nextInt();
        scanner.close();

        // Creamos la tarea y el hilo
        Runnable tarea = new RangoTask(n1, n2);
        Thread hilo = new Thread(tarea);

        // Lanzamos el hilo
        hilo.start();

        // Mensaje del programa principal
        System.out.println("El hilo se ha lanzado");
    }
}
