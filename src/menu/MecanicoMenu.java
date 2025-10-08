package menu;

import app.BaseDatos;
import controlador.MecanicoControlador;
import modelos.Mecanico;
import util.Consola;

import java.io.IOException;

public class MecanicoMenu {

    private MecanicoControlador controlador = new MecanicoControlador();

    private int mostrar() throws IOException {
        Consola.println("""
        =========== SOPLADOS S.A ==========
        [1] Registrar Mecanico
        [2] Consultar Mecanico (cedula)
        [3] Listar todos los Mecanicos
        [4] Eliminar Mecanico
        [5] Regresar
        ===================================
        """);

        int opcion = Consola.readInt("Seleccione una opcion");
        return opcion;
    }

    public void activar() throws IOException{
        int opcion = mostrar();
        switch (opcion){
            case 1: registrar(); break;
            case 2: buscar(); break;
            case 3: listar(); break;
            case 4: eliminar(); break;
            case 5: return;
            default:
                Consola.println("Opcion invalida. Intente nuevamente");

        }
    }

    public void registrar() throws IOException{
        String nombre = Consola.readln("Ingrese el nombre del mecanico");
        String cedula = Consola.readln("Ingrese el cedula del mecanico");
        String telefono = Consola.readln("Ingrese el telefono del mecanico");
        String correo = Consola.readln("Ingrese el correo del mecanico");
        String especialidad = Consola.readln("Ingrese el especialidad del mecanico");

        if (!controlador.registrar(nombre, cedula, telefono, correo, especialidad)) {
            Consola.println("El mecanico ya se encuentra registrado");
        }

        Consola.println("Mecanico registrado correctamente");
    }

    public void buscar() throws IOException{
        String cedula = Consola.readln("Ingrese el cedula del mecanico");
        Mecanico mecanico = controlador.buscar(cedula);
        if (mecanico == null) {
            Consola.println("El mecanico no existe");
        }

        Consola.println(mecanico.toString());
    }

    public void listar() throws IOException{
        Consola.println("Lista de mecanico: " + BaseDatos.listarTodosMecanico());
    }

    public void eliminar() throws IOException{
        String cedula = Consola.readln("Ingrese la cedula del mecanico");
        if (!controlador.eliminar(cedula)) {
            Consola.println("El mecanico no existe");
        }
        Consola.println("Mecanico eliminado correctamente");
    }
}