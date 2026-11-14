package ejercicios.ejercicio2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    // Códigos de color ANSI para la consola
    private static final String RESET = "\u001B[0m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String ROJO = "\u001B[31m";
    private static final String CIAN = "\u001B[36m";
    private static final String GRIS = "\u001B[90m";

    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    // Método base sincronizado para evitar que dos hilos mezclen texto en la consola
    private static synchronized void imprimir(String nivel, String color, String origen, String mensaje) {
        String hora = LocalTime.now().format(FORMATO_HORA);
        String hilo = Thread.currentThread().getName();
        
        System.out.printf("%s[%s]%s %s%-7s%s %s(%s)%s [%s]: %s%n",
                GRIS, hora, RESET,
                color, nivel, RESET,
                CIAN, hilo, RESET,
                origen, mensaje);
    }

    public static void info(String origen, String mensaje) {
        imprimir("INFO", CIAN, origen, mensaje);
    }

    public static void exito(String origen, String mensaje) {
        imprimir("OK", VERDE, origen, mensaje);
    }

    public static void aviso(String origen, String mensaje) {
        imprimir("WARN", AMARILLO, origen, mensaje);
    }

    public static void error(String origen, String mensaje) {
        imprimir("ERROR", ROJO, origen, mensaje);
    }
}