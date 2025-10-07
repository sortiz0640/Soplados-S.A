package menu;

import util.Consola;
import controlador.ClienteControlador;
import java.io.IOException;

public class Cliente {

    private ClienteControlador controlador = new ClienteControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar cliente
        [2] Consultar cliente (cedula)
        [3] Listar todos los clientes
        [4] Eliminar cliente
        [5] Regresar
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException{
        int opcion = mostrar();
        switch (opcion){
            case 1: controlador.registrar(); break;
            case 2: controlador.buscar(); break;
            case 3: controlador.listar(); break;
            case 4: controlador.eliminar(); break;
            case 5: return;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");

        }
    }
}