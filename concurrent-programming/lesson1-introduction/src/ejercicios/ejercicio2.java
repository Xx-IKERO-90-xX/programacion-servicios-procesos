package ejercicios;

import java.util.Scanner;
import java.util.Random;

class PrimesNumberGenerator implements Runnable {
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
            
        }
        return true;
    }

    @Override
    public void run() {
        Random random = new Random();
        String threadName = Thread.currentThread().getName();

        int randomNum = random.nextInt(100) + 1;
        System.out.println("[" + threadName + "] Ha elegido el número límite: " + randomNum);
        
        for (int i = 1; i <= randomNum; i++) {
            if (isPrime(i)) {
                System.out.println("[" + threadName + "] Número primo: " + i);

                try {
                    // Pausa aleatoria entre 500 y 1000 milisegundos (500 a 1000 inclusive)
                    int pausa = random.nextInt(501) + 500;
                    Thread.sleep(pausa);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("[" + threadName + "] El hilo fue interrumpido.");
                    break;
                }
            }
        }
        System.out.println("[" + threadName + "] Ha finalizado su ejecución.");
    }
}


public class ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de hilos a lanzar (n): ");
        int n = scanner.nextInt();
        scanner.close();

        // Lanzamos n hilos
        for (int i = 1; i <= n; i++) {
            Runnable tarea = new PrimesNumberGenerator();
            // Asignamos el nombre correspondiente al hilo ("Hilo 1", "Hilo 2", ...)
            Thread hilo = new Thread(tarea, "Hilo " + i);
            hilo.start();
        }

        System.out.println("Se han lanzado los " + n + " hilos correctamente.\n");
    }

}
