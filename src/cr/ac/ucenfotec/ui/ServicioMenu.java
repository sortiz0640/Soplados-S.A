package cr.ac.ucenfotec.ui;
import cr.ac.ucenfotec.controlador.ServicioControlador;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.util.Consola;
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
        int opcion;
        do {
            opcion = mostrar();
            switch (opcion){
                case 1: registrar(mecanico); break;
                case 2: eliminar(mecanico); break;
                case 3: break;
                default:
                    Consola.println("Opcion invalida. Intente nuevamente");

            }
        } while (opcion != 3);

    }

    public void registrar(Mecanico mecanico) throws IOException {

        boolean continuar = true;
        while (continuar) {
            String nombre = Consola.readln("Ingrese el nombre del servicio: ").trim().toUpperCase();;

            if (!servicioControlador.registrar(nombre, mecanico)) {
                Consola.println("El servicio ya existe.");
            } else {
                Consola.println("Servicio registrado correctamente.");
            }

            String opcion = Consola.readln("¿Desea agregar otro servicio? [Y/N]: ").trim().toUpperCase();
            continuar = opcion.equals("Y");

        }
    }

    public void eliminar(Mecanico mecanico) throws IOException {

        boolean continuar = true;

        while (continuar) {
            String nombre = Consola.readln("Ingrese el nombre del servicio: ").trim().toUpperCase();;

            if (servicioControlador.eliminar(nombre, mecanico)) {
                Consola.println("Servicio eliminado correctamente.");
            } else {
                Consola.println("El servicio especificado no existe");
            }

            String opcion = Consola.readln("¿Desea eliminar otro servicio? [Y/N]: ").trim().toUpperCase();
            continuar = opcion.equals("Y");

        }
    }
}



