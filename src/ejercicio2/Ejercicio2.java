package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {

    /**
     * Pre: ---
     * Post: Dado el fichero “textoExamen.txt”, implementa un método
     * palabrasMasLargasQue(int longitud) el cual devuelve un entero
     * indicando el número de palabras del texto cuya longitud es mayor
     * o igual que [longitud].
     */
    public static int palabrasMasLargasQue(int longitud, String ruta) {
        File file = new File(ruta);
        int contador = 0;

        try {

            Scanner f = new Scanner(file);

            while (f.hasNextLine()) {
                String line = f.nextLine();
                line = line
                        .replaceAll("\\.", "").replaceAll(":", "")
                        .replaceAll("\"", "").replaceAll(",", "")
                        .replaceAll("\\)", "").replaceAll("\\(", "");
                String[] lineSp = line.split(" ");
                for (int i = 0; i < lineSp.length; i++) {
                    if (lineSp[i] != " ") {
                        System.out.println(lineSp[i]);
                        if (lineSp[i].length() > longitud) {
                            contador++;
                        }
                    }
                }
                System.out.println(contador);
            }
        } catch (FileNotFoundException e) {
            System.out.println("RUTA DE FICHERO ERRONEA");
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("INGRESA RUTA COMPLETA DEL ARCHIVO TXT: ");
        String ruta = input.nextLine();
        System.out.println("INGRESAR LONGITUD A COMPARAR");
        try {
            int longitud = input.nextInt();
            palabrasMasLargasQue(longitud, ruta);
        } catch (Exception e) {
            System.out.println("ERROR NUMERO NO VALIDO");
        }
    }
}