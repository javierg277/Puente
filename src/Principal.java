public class Principal {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Persona persona = new Persona("Persona " + i);
            persona.start();

            try {
                Thread.sleep((long) (1000 + Math.random() * 29000)); // Tiempo entre 1 y 30 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
