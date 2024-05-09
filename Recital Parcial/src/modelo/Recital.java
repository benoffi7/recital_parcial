package modelo;

public class Recital
{
    private String nombre;
    private String fecha;
    private String lugar;

    public Recital()
    {
        nombre = "El recital más Gonzalo que el mismo Gonzalo";
        lugar = "Santiago del Estero";
        fecha = "El domingo pasado";
    }

    public Recital(String nombre, String fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
