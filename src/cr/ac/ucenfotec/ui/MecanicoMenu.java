package cr.ac.ucenfotec.ui;

import cr.ac.ucenfotec.BaseDatos;
import cr.ac.ucenfotec.controlador.MecanicoControlador;
import cr.ac.ucenfotec.modelos.Mecanico;
import cr.ac.ucenfotec.util.Consola;

import java.io.IOException;

public class MecanicoMenu {

    // Esta clase se utiliza para el manejo de mecanicos. Depende de multiples clases para funcionar (BaseDatos, Consola, Cliente, ClienteControlador)

    private MecanicoControlador controlador = new MecanicoControlador();

    // Muestra el metodo en pantalla
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
        int opcion;
        do {
            opcion = mostrar(); // Llama el metodo mostrar() hasta que el usuario decida romper el bucle
            switch (opcion){
                case 1: registrar(); break;
                case 2: buscar(); break;
                case 3: listar(); break;
                case 4: eliminar(); break;
                case 5: break;
                default:
                    Consola.println("Opcion invalida. Intente nuevamente");

            }
        } while (opcion != 5);

    }

    public void registrar() throws IOException{
        String nombre = Consola.readln("Ingrese el nombre del mecanico");
        String cedula = Consola.readln("Ingrese el cedula del mecanico");
        String telefono = Consola.readln("Ingrese el telefono del mecanico");
        String correo = Consola.readln("Ingrese el correo del mecanico");
        String especialidad = Consola.readln("Ingrese el especialidad del mecanico");

        if (!controlador.registrar(nombre, cedula, telefono, correo, especialidad)) {
            Consola.println("El mecanico ya se encuentra registrado");
            return;
        }

        Consola.println("Mecanico registrado correctamente");
        Consola.println("A continuacion, agregue los servicios que impartira el mecanico...");

        /* INSTANCIA SERVICIO: Crea una instancia del mecanico recien registrado y se envia a ServicioMenu
               > ServicioMenu se encarga de solicitar los servicios que imparte el mecanico */

        ServicioMenu servicioMenu = new ServicioMenu(); // Se crea una instancia del menu de los servicios
        Mecanico mecanico = controlador.buscar(cedula);
        servicioMenu.activar(mecanico); // Se activa el menu de servicios y se envia el mecanico recien registrado.

    }

    // Imprime en pantalla el mecanico especificado según cedula
    public void buscar() throws IOException{
        String cedula = Consola.readln("Ingrese el cedula del mecanico");
        Mecanico mecanico = controlador.buscar(cedula);
        if (mecanico == null) {
            Consola.println("El mecanico no existe");
            return;
        }

        Consola.println(mecanico.toString());
    }
    // Imprime todos los mecanicos guardados
    public void listar() throws IOException{
        Consola.println("Lista de mecanico: " + BaseDatos.listarTodosMecanicos());
    }

    // Elimina mecanico segun cedula
    public void eliminar() throws IOException{
        String cedula = Consola.readln("Ingrese la cedula del mecanico");
        if (!controlador.eliminar(cedula)) {
            Consola.println("El mecanico no existe");
            return;
        }
        Consola.println("Mecanico eliminado correctamente");
    }
}