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

    public ArrayList<OrdenServicio> getOrdenServicios() {
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
        return super.toString();
    }


}
