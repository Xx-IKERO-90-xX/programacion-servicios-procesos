package ejercicios.ejercicio3;

import java.util.List;
import java.util.Random;

public class Robot implements Runnable {
    private final String unidad;
    private final List<Posicion> camino;
    private final Random random = new Random();

    public Robot(String unidad, List<Posicion> camino) {
        this.unidad = unidad;
        this.camino = camino;
    }

    @Override
    public void run() {
        Logger.info(unidad, "Iniciar su recorrido.");
        int indiceActual = 0;
        while (indiceActual < camino.size()) {
            Posicion posicion = camino.get(indiceActual);
            
            try {
                boolean exito = posicion.entrar(unidad);
                if (exito) {
                    Thread.sleep(3000);
                    posicion.salir(unidad);
                    indiceActual++;
                } else {
                    Logger.aviso(unidad, "Retrocediendo por conflicto en el cruce!");

                    if (indiceActual > 0) {
                        indiceActual--;
                    }

                    int tiempoEspera = random.nextInt(1001) + 500;
                    Thread.sleep(tiempoEspera);
                }
            } catch (InterruptedException e) {
                Logger.error(unidad, "Fue interrumpido.");
                Thread.currentThread().interrupt();
                break;
            }
        }

        Logger.exito(unidad, "Ha compleetado su camino con éxito!");
    }

    public String getUnidad() {
        return unidad;
    }
}
