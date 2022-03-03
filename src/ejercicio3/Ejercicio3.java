package ejercicio3;


import javax.security.auth.login.AccountLockedException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class Ejercicio3 {

    /**
     * Pre: ---
     * Post: Implementa un método informacionVideojuegos() que devuelve un
     * ArrayList<String> que agrupe todas las plataformas para las que hay
     * videojuegos en el fichero entregado. Es decir, se debe almacenar UNA
     * SOLA VEZ, cada una de las plataformas que aparecen en el fichero .csv
     */
    public static ArrayList<String> informacionVideojuegos(String ruta) {
        int lineas = 0;
        File file = new File(ruta);
        ArrayList<String> consolas = new ArrayList<String>();
        try {
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                if (lineas == 0) {
                    String line = f.nextLine();
                }
                lineas++;
                String line = f.nextLine();
                ArrayList<String> l = new ArrayList<String>();
                String[] lineSp = line.split(",");
                String paste = "";
                boolean start = false;
                for (String field : lineSp) {
                    if (start) {
                        paste = paste + field;
                        if (!field.equals("") && Character.toString(field.charAt(field.length() - 1)).equalsIgnoreCase("\"")) {
                            start = false;
                            l.add(paste);
                            paste = "";
                        }
                    } else {
                        if (!field.equals("") && !Character.toString(field.charAt(field.length() - 1)).
                                equalsIgnoreCase("\"") &&
                                Character.toString(field.charAt(0)).equalsIgnoreCase("\"")) {
                            start = true;
                            paste = field;
                        } else {
                            l.add(field);
                        }
                    }
                }
                if (consolas.isEmpty()) {
                    consolas.add(l.get(2));
                } else if (!consolas.contains(l.get(2))) {
                    consolas.add(l.get(2));
                }
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("!!!RUTA DE FICHERO ERRONEA!!!");
        }
        return consolas;
    }

    public static void main(String[] args) {
        System.out.println("******************************");
        System.out.println("*        EJERCICIO 3         *");
        System.out.println("******************************");
        Scanner input = new Scanner(System.in);
        System.out.println("INGRESA LA RUTA COMPLETA DEL FICHERO CSV ");
        String ruta = input.nextLine();
        ArrayList<String> consola = informacionVideojuegos(ruta);
        System.out.println("\nESTAS SON TODAS LAS CONSOLAS:");
        System.out.println(consola.toString());

    }
}
