package controlador;

import app.BaseDatos;
import modelos.Mecanico;
import util.Consola;

import java.io.IOException;

public class MecanicoControlador {

    public void registrar() throws IOException {
        String nombre = Consola.readln("Ingrese el nombre del mecanico");
        String cedula = Consola.readln("Ingrese el cedula del mecanico");
        String telefono = Consola.readln("Ingrese el telefono del mecanico");
        String correo = Consola.readln("Ingrese el correo del mecanico");
        String especialidad = Consola.readln("Ingrese la especialidad del mecanico");
        double tarifaHora =- Consola.readDouble("Ingrese la tarifa x hora del mecanico");
        Mecanico nuevoMecanico = new Mecanico(nombre, cedula, telefono, correo, especialidad, tarifaHora);
        BaseDatos.listaMecanicos.add(nuevoMecanico);
        Consola.println("Cliente registrado correctamente");
    }

    public Mecanico buscar() throws IOException {
        String cedula = Consola.readln("Ingrese la cedula del mecanico: ");
        boolean encontrado = false;

        for (Mecanico mecanico : BaseDatos.listaMecanicos) {
            if (mecanico.getCedula().equals(cedula)) {
                Consola.println("Cliente encontrado correctamente");
                encontrado = true;
                return mecanico;
            }
        }

        if (!encontrado) {
            Consola.println("El cliente no existe");
        }

        return null;
    }

    public void listar() {
        if (BaseDatos.listaMecanicos.isEmpty()) {
            Consola.println("No hay clientes registrados");
        } else {
            Consola.println("Lista de Clientes ");
            for (Mecanico mecanico : BaseDatos.listaMecanicos) {
                Consola.println(mecanico.toString());
            }
        }
    }

    public void eliminar() throws IOException {
        String cedula = Consola.readln("Ingrese la cedula del cliente: ");

        boolean encontrado = false;
        for (Mecanico mecanico : BaseDatos.listaMecanicos) {
            if (mecanico.getCedula().equals(cedula)) {
                Consola.println("Cliente eliminado correctamente");
                BaseDatos.listaMecanicos.remove(mecanico);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Consola.println("El cliente no existe");
        }
    }

    public void agregarServicios() throws IOException {

    }
}
