package menu;

import controlador.ClienteControlador;
import util.Consola;

import java.io.IOException;

public class Mecanico {

    private ClienteControlador controlador = new ClienteControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar nuevo mecanico
        [2] Buscar mecanico (cedula)
        [3] Listar todos los mecanicos
        [4] Eliminar mecanico
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
