package modelo;

import modelo.entradas.Entrada;
import modelo.interfaces.IControlPublico;
import modelo.interfaces.IVentaEntradas;

public class PartidoFutbol implements IVentaEntradas, IControlPublico {
    @Override
    public void cargarEntrada(Entrada entrada, String tipo) {

    }

    @Override
    public int obtenerCantidadEntradasTipo(String tipo) {
        return 0;
    }

    @Override
    public int obtenerCantidadEntradasVendidasTipo(String tipo) {
        return 0;
    }

    @Override
    public String devolverListadoEntradasDisponibles(String tipo) {
        return null;
    }

    @Override
    public float devolverTotalRecaudado() {
        return 0;
    }

    @Override
    public boolean venderEntrada(String tipo) {
        return false;
    }
}
