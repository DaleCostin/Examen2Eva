package ejercicio1;

import java.text.SimpleDateFormat;

public class Jugador {

    /**
     * Pre: ---
     * Post: Desarrolla la clase Jugador, formada por un nombre, dorsal, potencia de disparo,
     * calidad en la portería, y vidas (se inicializa siempre con valor 2). Además, implementa los
     * métodos habilidadDisparo() y habilidadPorteria(). Programa los métodos como creas conveniente,
     * usando los atributos potencia de disparo y calidad en la portería (ambos deben devolver un número entero).
     * Ten en cuenta que, para saber si el jugador que ha disparado ha metido gol, deberás usar
     * los métodos habilidadDisparo() del lanzador y el método habilidadPorteria() del portero.
     * Una vez hayas completado el paso anterior, programa la clase Main que permita jugar al juego.
     */

    private String nombre;
    private int dorsal;
    private int potencia;
    private int calidad;
    private int vidas;

    public Jugador(String nombre, int dorsal, int potencia , int calidad) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.potencia = potencia;
        this.calidad = calidad;
        this.vidas = 2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int sueldoBase) {
        this.dorsal = dorsal;
    }

    public int getPotenca() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    @Override
    public String toString() {
        return "Jugador -> [nombre = " + nombre +
                ", dorsal = " + dorsal + ", potencia = " + potencia +
                ", calidad = " + calidad + ", vidas = " +
                vidas + "]";
    }
}
