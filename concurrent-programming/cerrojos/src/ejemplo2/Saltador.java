package ejemplo2;

public class Saltador implements Runnable {
    private final Piscina piscina;
    private final String nombre;

    public Saltador(Piscina piscina, String nombre) {
        this.piscina = piscina;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            piscina.nadar(nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nombre + " fue interrumpido mientras esperaba.");
        }
    }
}
