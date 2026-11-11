package ejemplo2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventario inventarioIkero = new Inventario("Ikero90");
        Inventario inventarioManu = new Inventario("Manu");
        SistemaIntercambio sistemaIntercambio = new SistemaIntercambio();

        Thread hilo1 = new Thread(
            () -> sistemaIntercambio.intercambiarObjectos(inventarioIkero, inventarioManu), "Hilo1-ikero->manu"
        );
        Thread hilo2 = new Thread(
            () -> sistemaIntercambio.intercambiarObjectos(inventarioManu, inventarioIkero), "Hilo2-manu->ikero"
        );

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Intercambio finalizado.");
    }    
}
