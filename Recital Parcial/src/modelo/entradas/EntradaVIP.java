package modelo.entradas;

public class EntradaVIP extends Entrada{
    private String beneficio;

    public EntradaVIP(int id, String beneficio) {
        super(id);
        this.beneficio = beneficio;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public String obtenerTipo() {
        return "VIP";
    }

    @Override
    public float obtenerPrecioTotal() {
        return super.obtenerPrecioTotal() * (float)1.5;
    }

    @Override
    public String toString() {
        return "EntradaVIP{" +
                "beneficio='" + beneficio + '\'' +
                "}\"Precio total: "+obtenerPrecioTotal()+ '\'' + super.toString();
    }
}
