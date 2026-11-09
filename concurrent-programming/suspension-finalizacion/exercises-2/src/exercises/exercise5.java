package exercises;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Pedimos la frecuencia al usuario en segundos
        System.out.print("Indica cada cuántos segundos quieres que se guarde el saludo: ");
        int segundos = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        // 2. Creamos el hilo utilizando una expresión lambda
        Thread hiloEscritor = new Thread(() -> {
            String nombreArchivo = "saludo.txt";
            
            // Usamos try-with-resources para asegurar que el BufferedWriter y FileWriter 
            // se cierren automáticamente de forma correcta al producirse la interrupción.
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
                
                // El hilo escribe de forma indefinida hasta que reciba una interrupción
                while (true) {
                    writer.write("¡Hola mundo!");
                    writer.newLine();
                    writer.flush(); // Forzamos a que se guarde inmediatamente en el archivo físico

                    // Espera el tiempo indicado por el usuario (convertido a milisegundos)
                    Thread.sleep(segundos * 1000L);
                }
                
            } catch (InterruptedException e) {
                // Al recibir el interrupt(), Thread.sleep lanza InterruptedException
                System.out.println("Interrumpiendo hilo");
                Thread.currentThread().interrupt(); // Restauramos el flag de interrupción
            } catch (IOException e) {
                System.out.println("Error de E/S al escribir en el fichero: " + e.getMessage());
            }

            System.out.println("Hilo interrumpido");
        });

        // 3. Lanzamos el hilo
        hiloEscritor.start();

        // 4. El programa principal pregunta al usuario si quiere salir (pulsar ENTER)
        System.out.print("Pulsa enter para interrumpir el hilo:");
        scanner.nextLine(); // Se bloquea esperando a que el usuario pulse Enter
        scanner.close();

        // 5. Interrumpimos el hilo cuando el usuario pulsa Enter
        hiloEscritor.interrupt();

        try {
            // Esperamos a que el hilo termine de cerrar el archivo y finalice por completo
            hiloEscritor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 6. Mensaje final de despedida
        System.out.println("¡Adiós!");
    }
}
