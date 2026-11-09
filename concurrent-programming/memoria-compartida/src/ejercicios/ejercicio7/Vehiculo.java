package ejercicios.ejercicio7;

public class Vehiculo {
    private Motor motor = null;
    private Bateria bateria = null;
    private Carroceria carroceria = null;

    public synchronized void ensamblarMotor(Motor motor) throws InterruptedException {
        if(carroceria != null){
            this.motor = motor;
            wait();
        } else {
            System.out.println("Error, no se puede ensamblar el motor sin carrocería");
        }
    }

    public synchronized void ensamblarBateria(Bateria bateria) throws InterruptedException {
        if(carroceria != null){
            this.bateria = bateria;
            wait();
        } else {
            System.out.println("Error, no se puede ensamblar la batería sin carrocería");
        }
    }

    public synchronized void ensamblarCarroceria(Carroceria carroceria) throws InterruptedException {
        this.carroceria = carroceria;
        notifyAll();
    }

    public Motor getMotor() {
        return motor;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "motor=" + motor +
                ", bateria=" + bateria +
                ", carroceria=" + carroceria +
                '}';
    }
}
