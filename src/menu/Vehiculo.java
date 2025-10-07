package menu;
import controlador.VehiculoControllador;
import util.Consola;

import java.io.IOException;

public class Vehiculo {
    private VehiculoControllador controlador = new VehiculoControllador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar nuevo vehiculo
        [2] Buscar vehiculo
        [3] Listar todos los vehiculos
        [4] Historial de Ordenes de Servicio
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
            case 4: controlador.historial(); break;
            case 5: return;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");

        }
    }
}
