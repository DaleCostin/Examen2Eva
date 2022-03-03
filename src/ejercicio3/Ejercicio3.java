package ejercicio3;


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
        File file = new File(ruta);
        ArrayList<String> consolas = new ArrayList<String>();
        try {
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                String line = f.nextLine();
                line = line.replaceAll("%\"%\"%","");
                String[] lineSp = line.split(",");
                for (int i = 0; i < lineSp.length; i++) {
                    if (consolas.isEmpty()){
                        consolas.add(lineSp[2]);
                    } else if (!consolas.contains(lineSp[2])){
                        consolas.add(lineSp[2]);
                    }
                }
            }
            System.out.println(consolas.toString());
        } catch (FileNotFoundException e) {
            System.out.println("!!!RUTA DE FICHERO ERRONEA!!!");
        }
        return  consolas;
    }

    public static void main(String[] args) {
        System.out.println("******************************");
        System.out.println("*        EJERCICIO 3         *");
        System.out.println("******************************");
        Scanner input = new Scanner(System.in);
        System.out.println("INGRESA LA RUTA COMPLETA DEL FICHERO CSV ");
        String ruta = input.nextLine();
        System.out.println("");
        ArrayList<String> consola = informacionVideojuegos(ruta);

    }
}
