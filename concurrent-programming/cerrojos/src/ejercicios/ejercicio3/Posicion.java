package ejercicios.ejercicio3;

public interface Posicion {
    boolean entrar(String unidad) throws InterruptedException;
    void salir(String unidad);
}