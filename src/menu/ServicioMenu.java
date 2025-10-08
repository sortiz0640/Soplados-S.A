package menu;
import controlador.ServicioControlador;
import modelos.Mecanico;
import util.Consola;
import java.io.IOException;

public class ServicioMenu {

    ServicioControlador servicioControlador = new ServicioControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar Servicio
        [2] Eliminar Servicio
        [3] Regresar
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar(Mecanico mecanico) throws IOException{
        int opcion = mostrar();
        switch (opcion){
            case 1: registrar(mecanico); break;
            case 2: eliminar(mecanico); break;
            case 3: return;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");

        }
    }

    public void registrar(Mecanico mecanico) throws IOException {

        boolean continuar = true;
        while (continuar) {
            String nombre = Consola.readln("Ingrese el nombre del servicio: ").trim().toUpperCase();;
            double costo = Consola.readDouble("Ingrese el costo del servicio: ");

            if (!servicioControlador.registrar(nombre, costo, mecanico)) {
                Consola.println("El servicio ya existe.");
                activar(mecanico);
            } else {
                Consola.println("Servicio registrado correctamente.");
            }

            String opcion = Consola.readln("¿Desea agregar otro servicio? [Y/N]: ").trim().toUpperCase();
            continuar = opcion.equals("Y");

        }
    }

    public void eliminar (Mecanico mecanico) throws IOException {

        boolean continuar = true;

        while (continuar) {
            String nombre = Consola.readln("Ingrese el nombre del servicio: ").trim().toUpperCase();;

            if (servicioControlador.eliminar(nombre, mecanico)) {
                Consola.println("Servicio eliminado correctamente.");
            } else {
                Consola.println("El servicio especificado no existe");
            }

            String opcion = Consola.readln("¿Desea agregar otro servicio? [Y/N]: ").trim().toUpperCase();
            continuar = opcion.equals("Y");

        }
    }
}



