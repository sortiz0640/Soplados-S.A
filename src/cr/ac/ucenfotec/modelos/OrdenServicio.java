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

    public void setNumeroOrden() {
        this.numeroOrden = generarNumeroOrden();
    }

    public int generarNumeroOrden() {
        return (int) (Math.random() * 9000) + 1000;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaEntregaEstimada() {
        return fechaEntregaEstimada;
    }

    public void setFechaEntregaEstimada(LocalDateTime fechaEntregaEstimada) {
        this.fechaEntregaEstimada = fechaEntregaEstimada;
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

        sb.append("══════════════════════════════════════════════\n");
        sb.append("              🧾 ORDEN DE SERVICIO\n");
        sb.append("══════════════════════════════════════════════\n");
        sb.append("Número de Orden: ").append(numeroOrden).append("\n");
        sb.append("Cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("Vehículo: ").append(vehiculo.getNumeroPlaca()).append("\n");
        sb.append(mecanico.toString()).append("\n");
        sb.append("Fecha de ingreso: ").append(formatearFecha(fechaIngreso)).append("\n");
        sb.append("Fecha entrega estimada: ").append(formatearFecha(fechaEntregaEstimada)).append("\n");
        sb.append("══════════════════════════════════════════════\n");

        return sb.toString();
    }




}
