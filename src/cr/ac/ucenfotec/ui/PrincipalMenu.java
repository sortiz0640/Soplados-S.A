package cr.ac.ucenfotec.ui;
import cr.ac.ucenfotec.util.Consola;
import java.io.IOException;
public class PrincipalMenu {

    private ClienteMenu clienteMenu = new ClienteMenu();
    private MecanicoMenu mecanicoMenu = new MecanicoMenu();
    private OrdenServicioMenu ordenServicioMenu = new OrdenServicioMenu();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Gestion de Clientes
        [2] Gestion de Mecanicos
        [3] Gestion de Ordenes de Servicio
        [5] Salir
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException {
        int opcion;
        do {
            opcion = mostrar(); // Llama el metodo mostrar() hasta que el usuario decida romper el bucle
            switch (opcion) {
                case 1: clienteMenu.activar(); break;
                case 2: mecanicoMenu.activar(); break;
                case 3: ordenServicioMenu.activar(); break;
                case 5: break;
                default:
                    Consola.println("Opcion invalida. Intente nuevamente");
                    break;
            }
        } while (opcion != 5);

    }

}
