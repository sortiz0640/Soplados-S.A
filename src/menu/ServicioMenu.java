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

    public void registrar(Mecanico mecanico) throws IOException{

        String nombre = Consola.readln("Ingrese el nombre del servicio: ");
        double costo = Consola.readDouble("Ingrese el costo del servicio: ");

        boolean nuevoServicio = servicioControlador.registrar(nombre, costo, mecanico);

        if(!nuevoServicio){
            Consola.println("El servicio ya existe");
            activar(mecanico);
        }

        Consola.println("Servicio registrado correctamente");
    }

    public void eliminar(Mecanico mecanico) throws IOException{

    }



}
