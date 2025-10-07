package modelos;

import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<OrdenServicio> listaOrdenServicios;

    public Cliente(String cedula, String nombre, String telefono, String correo) {
        super(cedula, nombre, telefono, correo);
    }

    public void agregarOrdenServicio(OrdenServicio ordenNueva) {
        this.listaOrdenServicios.add(ordenNueva);
    }

    public ArrayList<OrdenServicio> getOrdenServicios() {
        return listaOrdenServicios;
    }

    public void agregarVehiculo(Vehiculo vehiculos) {
        this.listaVehiculos.add(vehiculos);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
