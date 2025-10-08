package menu;
import modelos.Factura;
import modelos.OrdenServicio;
import modelos.Vehiculo;
import util.Consola;

import java.io.IOException;

public class PrincipalMenu {

    private ClienteMenu clienteMenu;
    private Vehiculo vehiculo;
    private MecanicoMenu mecanico;
    private OrdenServicio ordenServicio;
    private Factura facturacion;
    private

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Gestion de Clientes
        [2] Gestion de Mecanicos
        [3] Gestion de Ordenes de Servicio
        [4] Facturacion
        [5] Salir
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException {
        int opcion = mostrar();
        switch (opcion) {
            case 1: clienteMenu.activar(); break;
            case 2: mecanico.activar(); break;
            case 3: ordenServicio.activar(); break;
            case 4: facturacion.activar(); break;
            case 5: break;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");
                break;
        }
    }

}
