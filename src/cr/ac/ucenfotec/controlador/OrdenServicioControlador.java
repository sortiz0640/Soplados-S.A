package cr.ac.ucenfotec.controlador;

import cr.ac.ucenfotec.modelos.OrdenServicio;
import cr.ac.ucenfotec.modelos.Cliente;
import cr.ac.ucenfotec.modelos.Mecanico;

import java.io.IOException;

public class OrdenServicioControlador {

    public OrdenServicio crearOrdenServicio(Cliente cliente, String placa, Mecanico mecanico) throws IOException {

        OrdenServicio ordenServicio = new OrdenServicio(cliente, placa, mecanico);
        return ordenServicio;

    }

}
