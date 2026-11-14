package ejercicios.ejercicio1;

public class Recta implements Posicion {
    private final String nombre;

    public Recta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void entrar(String unidad) throws InterruptedException {
        Logger.info(nombre, unidad + " ha entrado en el tramo recto.");
        Thread.sleep(3000);
    }

    @Override
    public void salir(String unidad) {
        Logger.exito(nombre, unidad + " ha abandonado el tramo recto.");
    }

    public String getNombre() {
        return nombre;
    }
}
