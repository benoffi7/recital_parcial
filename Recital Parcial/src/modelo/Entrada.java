package modelo;

public class Entrada
{
    private int id;
    private float precio;
    private boolean disponibilidad;

    public Entrada(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return id == entrada.id;
    }
}
