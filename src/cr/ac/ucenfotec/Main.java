package cr.ac.ucenfotec;
import cr.ac.ucenfotec.ui.PrincipalMenu;

public class Main {

    public static void main(String[] args) throws Exception {

        PrincipalMenu menu = new PrincipalMenu();
        menu.activar();

        // Este método inicializa el menu principal del programa.

    }

   /*
        SOPLADOS S.A - PORTAFOLIO DE PROGRAMACIÓN ORIENTADA A OBJETOS
        ESTUDIANTE: Sebastian Ortiz Vargas

        Desglose de paquetes:

            - Modelos: Cuenta con las clases principales de cada objeto que usa el programa.

                > Cliente y Mechanic heredan una clase general llamada Persona que almacena datos básicos [Herencia]

            - UI: Clases enfocadas a menu de interacción con el usuario e impression de información.

                > Las clases dentro del paquete UI dependen de la clase Consola para la impression de mensajes [Dependencia]
                > También dependen de Controlador para las validaciones [Dependencia]

            - Controlador: Clases destinadas al guardado, actualización y eliminación de datos.

                > Depende de los modelos para la lógica y validation de los datos.

        Otros:

            - Util: Clases adicionales de apoyo como Consola y un Enum de validation
            - BaseDatos: Clase que guarda multiples arraylist para el guardado de datos simulando SQL por ejemplo

 */
}