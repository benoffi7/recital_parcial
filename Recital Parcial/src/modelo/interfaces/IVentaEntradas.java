package modelo.interfaces;

import modelo.entradas.Entrada;

public interface IVentaEntradas
{
    public boolean cargarEntrada(Entrada entrada, String tipo);
    public int obtenerCantidadEntradasTipo(String tipo);
    public int obtenerCantidadEntradasVendidasTipo(String tipo);
    public String devolverListadoEntradasDisponibles(String tipo);
    public float devolverTotalRecaudado();
    public boolean venderEntrada(String tipo);
}
