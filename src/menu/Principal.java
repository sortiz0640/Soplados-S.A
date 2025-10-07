package menu;
import modelos.Factura;
import modelos.OrdenServicio;
import modelos.Vehiculo;
import util.Consola;

import java.awt.*;
import java.io.IOException;

public class Principal {

    private Cliente cliente;
    private Vehiculo vehiculo;
    private Mecanico mecanico;
    private Repuesto repuestos;
    private OrdenServicio ordenServicio;
    private Factura facturacion;
    private

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Gestion de Clientes
        [2] Gestion de Vehiculos
        [3] Gestion de Mecanicos
        [4] Gestion de Repuestos
        [5] Gestion de Ordenes de Servicio
        [6] Facturacion
        [8] Salir
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException {
        int opcion = mostrar();
        switch (opcion) {
            case 1: cliente.activar(); break;
            case 2: vehiculo.activar(); break;
            case 3: mecanico.activar(); break;
            case 4: repuestos.activar(); break;
            case 5: ordenServicio.acvitar(); break;
            case 6: facturacion.activar(); break;
            case 8: break;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");
                break;
        }
    }

}
