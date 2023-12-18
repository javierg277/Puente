import java.util.Random;

class Persona extends Thread {
    private int peso;

    public Persona(String nombre) {
        super(nombre);
        Random rand = new Random();
        this.peso = rand.nextInt(81) + 40; // Peso aleatorio entre 40 y 120 kg
    }

    public int getPeso() {
        return peso;
    }

    public void run() {
        System.out.println(getName() + " ha llegado al puente.");
        Puente.pasarPuente(this);
    }
}

