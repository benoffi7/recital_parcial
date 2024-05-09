package modelo.entradas;

public abstract class Entrada
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

    private float getPrecio() {
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
    public abstract String obtenerTipo();

    public float obtenerPrecioTotal()
    {
        return precio;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", precio=" + precio +
                ", disponibilidad=" + disponibilidad +
                '}';
    }
}
