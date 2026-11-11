package ejemplo2;

public class SistemaIntercambio {
    public void intercambiarObjectos(Inventario origen, Inventario destino) {
        if (origen.getID() > destino.getID()) {
            Inventario aux = origen;
            origen = destino;
            destino = aux;
        }

        System.out.println(Thread.currentThread().getName() + " intenta bloquear el inventario de " + origen.getNombrePlayer());

        synchronized (origen) {
            System.out.println(Thread.currentThread().getName() + " ha bloqueado el inventario de " + origen.getNombrePlayer());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(Thread.currentThread().getName() + " intenta bloquear el inventario de " + destino.getNombrePlayer());

            synchronized(destino) {
                System.out.println(Thread.currentThread().getName() + " ha bloqueado el inventario de " + destino.getNombrePlayer());

                origen.deleteObject();
                destino.addObject();

                System.out.println(Thread.currentThread().getName() + " ha completado el intercambio: " + origen.getNombrePlayer() + " -> " + destino.getNombrePlayer());
            }
        }
    }
}
