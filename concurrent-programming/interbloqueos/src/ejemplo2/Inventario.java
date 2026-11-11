package ejemplo2;

import java.util.Random;

public class Inventario {
    private String nombrePlayer;
    private int objetos = 10;
    public final int ID = new Random().nextInt();

    public Inventario(String nombrePlayer) {
        this.nombrePlayer = nombrePlayer;
    }

    public int getID() {
        return ID;
    }

    public String getNombrePlayer() {
        return nombrePlayer;
    }

    public void deleteObject() {
        objetos--;
    }

    public void addObject() {
        objetos++;
    }
}
