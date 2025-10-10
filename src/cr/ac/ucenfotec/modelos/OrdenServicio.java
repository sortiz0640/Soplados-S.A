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

    public int generarNumeroOrden() {
        return (int) (Math.random() * 9000) + 1000;
    }

    private String formatearFecha(LocalDateTime fecha) {
        return fecha.getDayOfMonth() + "/" +
                fecha.getMonthValue() + "/" +
                fecha.getYear() + " " +
                String.format("%02d:%02d", fecha.getHour(), fecha.getMinute());
    }

    @Override
    public String toString() {
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
