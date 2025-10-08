package modelos;

import java.util.ArrayList;

public class Servicio {

    private String nombre;
    private Mecanico mecanicoAsignado;
    private double costo;

    public Servicio(String nombre, Mecanico mecanico, double costo) {
        this.nombre = nombre;
        this.mecanicoAsignado = mecanico;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mecanico getMecanicoAsignado() {
        return mecanicoAsignado;
    }

    public void setMecanicoAsignado(Mecanico mecanicoAsignado) {
        this.mecanicoAsignado = mecanicoAsignado;
    }


    public double getCostoServicio() {
        return costo;
    }

    public void setCostoServicio(double costoServicio) {
        this.costo = costoServicio;
    }

}
