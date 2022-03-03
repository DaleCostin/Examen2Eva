package ejercicio1;

import java.util.ArrayList;

public class Ejercicio1 {

    /**
     * Pre: ---
     * Post: “El rápido” es un clásico juego de fútbol en el que participan un total de N
     * jugadores (para este ejercicio van a ser 10). Su reglas son las siguientes: se organizan
     * los turnos de disparo de cada uno de los jugadores (de forma aleatorio). Uno de ellos se
     * sitúa en la portería y el siguiente dispara intentando meter gol. Si el jugador que ha
     * disparado consigue meter gol, se le resta 1 vida al portero. Sea cual sea el resultado
     * del disparo, el jugador que ha chutado a portería pasa a ser el portero en el siguiente
     * turno. El juego acaba cuando sólo queda un jugador vivo.
     */


    public static int jugadorAleatorio(int maximo) {
        int random = (int) (Math.random() * (maximo - 1) + 1);
        return random;
    }

    public static int potenciaDisparo() {
        return (int) (Math.random() * (99 - 50) + 50);
    }

    public static int calidadPorteria() {
        return (int) (Math.random() * (99 - 50) + 50);
    }

    public static int generarDorsal() {
        return (int) (Math.random() * 99) + 1;
    }

    public static String generarJugador() {
        String nombres[] = {"Enzo", "Oliver", "Alejandro", "Alvaro", "Manuel",
                "Julen", "Aaron", "Alberto", "Alexander", "Mikhail", "Nikolai",
                "Dimitri", "Bacari", "Boubacar", "Igor", "Eros", "Kowalski"};
        String apellidos[] = {"Sanchez", "Urriega", "Alvarez", "Dieguez", "Rodriguez",
                "Ivainov", "Socolov", "Popov", "Vasiliev", "Pablov", "Jordano",
                "Bianci", "Amatto", "Vitale", "Umbunde", "Adebayo", "Adeleke"};
        String n = "";
        n = n + nombres[(int) (Math.random() * (nombres.length))] +
                " " + apellidos[(int) (Math.random() * (apellidos.length))];
        return n;
    }

    public static ArrayList<Jugador> creacionJugadores(ArrayList<Jugador> array) {
        for (int i = 0; i < 11; i++) {
            Jugador jugador = new Jugador(generarJugador(), generarDorsal(), potenciaDisparo(), calidadPorteria());
            array.add(jugador);
        }
        return array;
    }


    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        creacionJugadores(jugadores);
        System.out.println("ESTOS SON LOS JUGADORES\n");
        for (int j = 0; j < jugadores.size(); j++) {
            System.out.print(jugadores.get(j).getNombre() + "(" + jugadores.get(j).getDorsal() + ")" + " ");
        }
        System.out.println("\n");
        System.out.println("***************************");
        System.out.println("*    COMIENZA EL JUEGO    *");
        System.out.println("***************************\n");
        ArrayList<Jugador> vivos = new ArrayList<Jugador>();
        vivos = jugadores;
        int np = 0;
        while (vivos.size() != 1 && !vivos.isEmpty()) {
            int jvivos = vivos.size();
            Jugador portero = vivos.get(jugadorAleatorio(jvivos));
            Jugador disparador = vivos.get(jugadorAleatorio(jvivos));
            if (portero.getCalidad() < disparador.getPotenca()) {
                if (portero.getVidas() > 0) {
                    portero.setVidas(portero.getVidas() - 1);
                } else {
                    vivos.remove(portero);
                }
            } else {
                if (disparador.getVidas() > 0) {
                    disparador.setVidas(disparador.getVidas() - 1);
                } else {
                    vivos.remove(disparador);
                }
            }
        }
            System.out.println("EL GANADOR ES: ");
            System.out.println(vivos.get(0));
    }
}
