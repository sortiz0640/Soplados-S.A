package modelos;

import java.util.ArrayList;

public class Servicio {

    private String idServicio;
    private String nombre;
    private String descripcion;
    private Mecanico mecanicoAsignado;
    private double horasTrabajadas;
    private double costoServicio;
    private ArrayList<ItemRepuesto> repuestosUsados;

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Mecanico getMecanicoAsignado() {
        return mecanicoAsignado;
    }

    public void setMecanicoAsignado(Mecanico mecanicoAsignado) {
        this.mecanicoAsignado = mecanicoAsignado;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public ArrayList<ItemRepuesto> getRepuestosUsados() {
        return repuestosUsados;
    }

    public void setRepuestosUsados(ArrayList<ItemRepuesto> repuestosUsados) {
        this.repuestosUsados = repuestosUsados;
    }
}
