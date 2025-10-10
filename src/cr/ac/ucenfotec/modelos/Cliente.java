package cr.ac.ucenfotec.modelos;

import java.util.ArrayList;

public class Cliente extends Persona {

    // Cliente: Presenta COMPOSICIÓN con Vehiculos, si un cliente se elimina, sus vehiculos también.
    // Almacena un arreglo de sus vehiculos y sus órdenes de servicio
    // Extiende la clase Persona para almacenar los datos básicos del cliente

    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private ArrayList<OrdenServicio> listaOrdenServicios = new ArrayList<>();

    // Constructor
    public Cliente(String nombre, String cedula, String telefono, String correo) {
        super(cedula, nombre, telefono, correo);
    }

    public void agregarOrdenServicio(OrdenServicio ordenNueva) {
        this.listaOrdenServicios.add(ordenNueva);
    }

    // Retorna el arreglo de listaOrdenServicios
    public ArrayList<OrdenServicio> getListaOrdenServicios() {
        return listaOrdenServicios;
    }

    // Agrega un vehiculo a ListaVehiculos
    public void agregarVehiculo(Vehiculo vehiculos) {
        this.listaVehiculos.add(vehiculos);
    }

    // Retorna el arreglo de listaVehiculos
    public ArrayList<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }


    // Devuelve el vehículo especificado, espera siempre un vehículo existente (se valida previamente en ControladorVehiculo)
    public Vehiculo getVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getNumeroPlaca().equals(placa))
                return vehiculo;
        }
        return null;
    }

    @Override
    public String toString() {

        // Generado con el apoyo de herramientas externas para mejorar el apartado visual.

        StringBuilder sb = new StringBuilder();
        sb.append("\n=== INFORMACION DEL CLIENTE ===\n");
        sb.append("Nombre: ").append(getNombre()).append("\n");
        sb.append("Cedula: ").append(getCedula()).append("\n");
        sb.append("Telefono: ").append(getTelefono()).append("\n");
        sb.append("Correo: ").append(getCorreo()).append("\n");

        sb.append("\nVehiculos registrados: ").append(listaVehiculos.size()).append("\n");
        for (Vehiculo v : listaVehiculos) {
            sb.append("  - ").append(v.getNumeroPlaca())
                    .append(" (").append(v.getMarca()).append(" ")
                    .append(v.getModelo()).append(")\n");
        }

        sb.append("Ordenes de servicio: ").append(listaOrdenServicios.size()).append("\n");

        return sb.toString();
    }


}
