package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
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


public class ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de hilos a lanzar (n): ");
        int n = scanner.nextInt();
        scanner.close();

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Runnable task = new PrimesNumberGenerator();
            Thread thread = new Thread(task, "Hilo " + i);
            threads.add(thread);
            thread.start();
        }

        System.out.println("\nSe han lanzado los " + n + " hilos correctamente. Iniciando monitorización...\n");

        boolean threadActives = true;
        while (threadActives) {
            threadActives = false;

            System.out.println("--- Estado de los hilos ---");

            for (Thread thread : threads) {
                long id = thread.threadId();
                String name = thread.getName();
                Thread.State status = thread.getState();

                System.out.println("ID: " + id + " | Nombre: " + name + " | Estado: " + status);
                
                if (thread.isAlive()) {
                    threadActives = true;
                }
            }
            System.out.println("------------------ \n");

            if (threadActives) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("El hilo principal es interrumpido.");
                    break;
                }
            }
        }
        System.out.println("Todos los hilos han finalizado. Programa principal terminado.");
    }
}