package cr.ac.ucenfotec.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;

public class Consola {

    // Clase para normalizar el uso de BufferedReader y PrintStream. Hace más fácil el uso de la consola
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static PrintStream out = System.out;

    // Imprime un mensaje en consola. Recibe el mensaje como parámetro
    public static void println(String msg) {
        out.println(msg);
    }

    // Imprime un mensaje en consola, y espera que se ingrese un string. Recibe el mensaje como parámetro
    public static String readln(String msg) throws IOException {
        out.println(msg + ": ");
        return in.readLine();
    }
    // Imprime un mensaje en consola, y espera que se ingrese un entero. No validaciones. Recibe el mensaje como parámetro
    public static int readInt(String msg) throws IOException {
        out.println(msg + ": ");
        return Integer.parseInt(in.readLine());
    }
}
