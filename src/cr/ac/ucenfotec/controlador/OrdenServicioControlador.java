package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.modelos.OrdenServicio;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.BaseDatos;
import java.io.IOException;

public class OrdenServicioControlador {

    public OrdenServicio crearOrdenServicio(Cliente cliente, String placa, Mecanico mecanico) throws IOException {

        OrdenServicio ordenServicio = new OrdenServicio(cliente, placa, mecanico);
        return ordenServicio;

    }

    public OrdenServicio getOrdenServicio(int numeroOrden) {
        for (Cliente cliente : BaseDatos.listaClientes) {
            for (OrdenServicio orden : cliente.getOrdenServicios()) {
                if (orden.getNumeroOrden() == numeroOrden) {
                    return orden;
                }
            }
        }
        return null;
    }

    public void eliminarOrdenServicio(int numeroOrden) {

    }
}
