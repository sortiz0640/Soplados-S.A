package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;

public class Consola {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static PrintStream out = System.out;

    public static void println(String msg) {
        out.println(msg);
    }

    public static String readln(String msg) throws IOException {
        out.println(msg + ": ");
        return in.readLine();
    }

    public static int readInt(String msg) throws IOException {
        out.println(msg + ": ");
        return Integer.parseInt(in.readLine());
    }

    public static double readDouble(String msg) throws IOException {
        out.println(msg + ": ");
        return Double.parseDouble(in.readLine());
    }
}
