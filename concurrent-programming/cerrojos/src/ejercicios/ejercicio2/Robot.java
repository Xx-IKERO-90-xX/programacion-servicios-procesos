package ejercicios.ejercicio2;

import java.util.List;

public class Robot implements Runnable {
    private final String unidad;
    private final List<Posicion> camino;

    public Robot(String unidad, List<Posicion> camino) {
        this.unidad = unidad;
        this.camino = camino;
    }

    @Override
    public void run() {
        Logger.info(unidad, "Iniciar su recorrido.");
        for (Posicion posicion : camino) {
            try {
                posicion.entrar(unidad);
                Thread.sleep(3000);
                
            } catch (InterruptedException e) {
                Logger.error(unidad, "Fue interrumpido durante el trayecto.");
                Thread.currentThread().interrupt();
                break;
            }
            Logger.exito(unidad, "Ha completado su camino!");
        }
    }

    public String getUnidad() {
        return unidad;
    }
}
