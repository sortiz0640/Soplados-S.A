package cr.ac.ucenfotec.modelos;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private ArrayList<OrdenServicio> listaOrdenServicios = new ArrayList<>();

    public Cliente(String nombre, String cedula, String telefono, String correo) {
        super(cedula, nombre, telefono, correo);
    }

    public void agregarOrdenServicio(OrdenServicio ordenNueva) {
        this.listaOrdenServicios.add(ordenNueva);
    }

    public ArrayList<OrdenServicio> getListaOrdenServicios() {
        return listaOrdenServicios;
    }

    public void agregarVehiculo(Vehiculo vehiculos) {
        this.listaVehiculos.add(vehiculos);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }

    public Vehiculo getVehiculoPorPlaca(String placa) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getNumeroPlaca().equals(placa))
                return vehiculo;
        }
        return null;
    }

    @Override
    public String toString() {

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
