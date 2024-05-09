package modelo.entradas;

public class EntradaGeneral extends Entrada
{
    private String zona;

    public EntradaGeneral(int id, String zona) {
        super(id);
        this.zona = zona;

    }

    public String getZona() {
        return zona;
    }
    @Override
    public String obtenerTipo()
    {
        return "Soy General";
    }
}
