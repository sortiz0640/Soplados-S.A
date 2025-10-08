package menu;
import controlador.ClienteControlador;
import controlador.VehiculoControlador;
import modelos.Cliente;
import modelos.Vehiculo;
import util.Consola;

import java.io.IOException;

public class VehiculoMenu {
    private VehiculoControlador controladorVehiculo = new VehiculoControlador();
    private ClienteControlador controladorCliente = new ClienteControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar nuevo vehiculo
        [2] Listar todos los vehiculos
        [3] Regresar
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar(Cliente cliente) throws IOException{
        int opcion = mostrar();
        switch (opcion){
            case 1: registrar(cliente); break;
            case 2: listar(cliente); break;
            case 3: return;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");

        }
    }

    public void registrar(Cliente cliente) throws IOException{

        String marca = Consola.readln("Ingrese Marca: ");
        String modelo = Consola.readln("Ingrese Modelo: ");
        String placa = Consola.readln("Ingrese Placa: ");
        int anioFabricacion = Consola.readInt("Ingrese AnioFabricacion: ");
        String kilometraje = Consola.readln("Ingrese Kilometraje: ");

        controladorVehiculo.registrar(cliente, marca,  modelo, placa, anioFabricacion, kilometraje);
        Consola.println("Vehiculo registrado correctamente.");

    }

    public void listar(Cliente cliente) throws IOException{

        for (Vehiculo vehiculo : cliente.getVehiculos()) {
            Consola.println(vehiculo.toString() + "\n");
        }
    }
}
