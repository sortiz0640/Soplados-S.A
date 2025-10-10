package cr.ac.ucenfotec.modelos;

import java.io.IOException;
import java.time.LocalDateTime;

public class OrdenServicio {
    private int numeroOrden;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaEntregaEstimada;
    private Mecanico mecanico;

    // Clase con AGREGACIÓN: La orden requiere de Cliente, Vehículo y Mecanico. Estas clases pueden existir sin OrdenServicio.

    public OrdenServicio(Cliente cliente, String placa, Mecanico mecanico) throws IOException {

        this.numeroOrden = generarNumeroOrden();
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.fechaIngreso = LocalDateTime.now();
        this.fechaEntregaEstimada = LocalDateTime.now().plusMonths(1);
        this.vehiculo = cliente.getVehiculoPorPlaca(placa);

    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    // Metodo para generar un número random de la orden. No se implementó alguna validation para evitar duplicados :C
    public int generarNumeroOrden() {
        return (int) (Math.random() * 9000) + 100000;
    }
    // Metodo generado con herramientas externas para mejorar la experiencia visual
    private String formatearFecha(LocalDateTime fecha) {
        return fecha.getDayOfMonth() + "/" +
                fecha.getMonthValue() + "/" +
                fecha.getYear() + " " +
                String.format("%02d:%02d", fecha.getHour(), fecha.getMinute());
    }

    @Override
    public String toString() {

        // Generado con el apoyo de herramientas externas para mejorar el apartado visual.

        StringBuilder sb = new StringBuilder();

        sb.append("╔════════════════════════════════════════════╗\n");
        sb.append("              🧾 ORDEN DE SERVICIO\n");
        sb.append("╠════════════════════════════════════════════╣\n");
        sb.append("Número de Orden: ").append(numeroOrden).append("\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("\n--- DETALLES DEL VEHÍCULO ---\n");
        sb.append("Placa: ").append(vehiculo.getNumeroPlaca()).append("\n");
        sb.append("Marca: ").append(vehiculo.getMarca()).append("\n");
        sb.append("Modelo: ").append(vehiculo.getModelo()).append("\n");
        sb.append("Año: ").append(vehiculo.getAnioFabricacion()).append("\n");
        sb.append("Kilometraje: ").append(vehiculo.getKilometraje()).append("\n");
        sb.append("\n--- MECÁNICO ASIGNADO ---\n");
        sb.append(mecanico.toString()).append("\n");
        sb.append("Fecha de ingreso: ").append(formatearFecha(fechaIngreso)).append("\n");
        sb.append("Fecha entrega estimada: ").append(formatearFecha(fechaEntregaEstimada)).append("\n");
        sb.append("╚════════════════════════════════════════════╝\n");

        return sb.toString();
    }
}
