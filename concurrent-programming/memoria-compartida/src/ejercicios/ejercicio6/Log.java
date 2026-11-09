package ejercicios.ejercicio6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Log {

    PrintWriter printWriter = null;

    public Log(){
        try {
            File file = new File("./Files");
            if (!file.exists()) {
                file.mkdir();
            }
            this.printWriter = new PrintWriter(new FileWriter("./Files/logs.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribir (int id, String cadena){

        // Escribimos en el fichero el id y la fecha y hora actual
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();

        printWriter.println("ID: " + id + " - " + dtf.format(now));
        printWriter.println(cadena);

        // Hacemos una espera aleatoria entre 1 y 50 milisegundos
        // Esta espera nos ayuda a forzar que se produzcan los problemas de concurrencia
        // y que no se produzcan solo de forma esporádica.
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(51));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cerrar(){
        if(printWriter != null){
            printWriter.close();
        }
    }
}
