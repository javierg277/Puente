class Puente {
    private static final int MAX_PERSONAS = 3;
    private static final int MAX_PESO = 200;
    private static int personasEnPuente = 0;
    private static int pesoEnPuente = 0;

    public static synchronized void pasarPuente(Persona persona) {
        while (personasEnPuente >= MAX_PERSONAS || pesoEnPuente + persona.getPeso() > MAX_PESO) {
            try {
                System.out.println(persona.getName() + " está esperando para cruzar el puente.");
                Puente.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        personasEnPuente++;
        pesoEnPuente += persona.getPeso();
        System.out.println(persona.getName() + " está cruzando el puente.");
        try {
            Thread.sleep((long) (10000 + Math.random() * 40000)); // Tiempo entre 10 y 50 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        personasEnPuente--;
        pesoEnPuente -= persona.getPeso();
        System.out.println(persona.getName() + " ha cruzado el puente.");

        Puente.class.notifyAll();
    }
}
