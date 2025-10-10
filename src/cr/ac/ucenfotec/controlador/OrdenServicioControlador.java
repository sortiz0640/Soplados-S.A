package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.modelos.OrdenServicio;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.BaseDatos;
import cr.ac.ucenfotec.modelos.Vehiculo;

import java.io.IOException;

public class OrdenServicioControlador {

    public OrdenServicio crearOrdenServicio(Cliente cliente, String placa, Mecanico mecanico) throws IOException {

        OrdenServicio ordenServicio = new OrdenServicio(cliente, placa, mecanico);
        cliente.agregarOrdenServicio(ordenServicio);
        return ordenServicio;

    }

    public OrdenServicio getOrdenServicio(int numeroOrden) {
        for (Cliente cliente : BaseDatos.listaClientes) {
            for (OrdenServicio orden : cliente.getListaOrdenServicios()) {
                if (orden.getNumeroOrden() == numeroOrden) {
                    return orden;
                }
            }
        }
        return null;
    }

    public boolean eliminarOrdenServicio(int numeroOrden) {
        for (Cliente cliente : BaseDatos.listaClientes) {
            for (OrdenServicio orden : cliente.getListaOrdenServicios()) {
                if (orden.getNumeroOrden() == numeroOrden) {
                    cliente.getListaOrdenServicios().remove(orden);
                    return true;
                }
            }
        }
        return false;
    }
}
