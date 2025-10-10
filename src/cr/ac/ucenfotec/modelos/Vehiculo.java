package cr.ac.ucenfotec.modelos;

public class Vehiculo {

    private String marca;
    private String modelo;
    private String numeroPlaca;
    private int anioFabricacion;
    private String kilometraje;

    // Clase con COMPOSICIÓN. Un vehículo solo puede existir si un cliente ha sido registrado, junto a un vehículo

    public Vehiculo(String marca, String modelo, String numeroPlaca, int anioFabricacion, String kilometraje) {

        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
        this.anioFabricacion = anioFabricacion;
        this.kilometraje = kilometraje;
    }

    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }


    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    @Override
    public String toString() {

        // Generado con el apoyo de herramientas externas para mejorar el apartado visual.

        StringBuilder sb = new StringBuilder();
        sb.append("═══ VEHÍCULO ═══\n");
        sb.append("Placa: ").append(numeroPlaca).append("\n");
        sb.append("Marca: ").append(marca).append("\n");
        sb.append("Modelo: ").append(modelo).append("\n");
        sb.append("Año de fabricación: ").append(anioFabricacion).append("\n");
        sb.append("Kilometraje: ").append(kilometraje).append(" km\n");
        sb.append("═══════════════");
        return sb.toString();
    }
}
