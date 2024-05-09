package modelo;

import modelo.entradas.Entrada;
import modelo.interfaces.IVentaEntradas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Recital implements IVentaEntradas
{
    private String nombre;
    private String fecha;
    private String lugar;

    //private HashMap<String, HashMap<String,Entrada>> entradas;

    //private HashSet<Entrada> entradas;

    private HashMap<String,HashSet<Entrada>> entradas;


    public Recital()
    {
        nombre = "El recital más Gonzalo que el mismo Gonzalo";
        lugar = "Santiago del Estero";
        fecha = "El domingo pasado";
        entradas = new HashMap<>();
    }

    public Recital(String nombre, String fecha, String lugar) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        entradas = new HashMap<>();
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

//    Cargar las entradas,

    /*
    public void cargarEntrada(Entrada entrada)
    {
        HashSet<Entrada> entradaHashSet ;

        if (entrada instanceof EntradaVIP)
        {
            if (entradas.containsKey("VIP")) //si ya tengo al menos una entrada vip
            {
                entradaHashSet = entradas.get("VIP"); //recupero actuales
            }
            else
            {
                entradaHashSet = new HashSet<>();
                entradas.put("VIP",entradaHashSet);
            }
            entradaHashSet.add(entrada); //agrego la nueva
        }
        else if (entrada instanceof EntradaGeneral)
        {
            if (entradas.containsKey("GENERAL")) //si ya tengo al menos una entrada vip
            {
                entradaHashSet = entradas.get("GENERAL"); //recupero actuales
            }
            else
            {
                entradaHashSet = new HashSet<>();
                entradas.put("GENERAL",entradaHashSet);
            }
            entradaHashSet.add(entrada); //agrego la nueva
        }
    }

     */

    public void cargarEntrada(Entrada entrada, String tipo)
    {
        HashSet<Entrada> entradaHashSet ;
        if (entradas.containsKey(entrada.obtenerTipo())) //si ya tengo al menos una entrada vip
        {
            entradaHashSet = entradas.get(tipo); //recupero actuales
        }
        else
        {
            entradaHashSet = new HashSet<>();
            entradas.put(tipo,entradaHashSet);
        }
        entradaHashSet.add(entrada); //agrego la nueva
    }

    public int obtenerCantidadEntradasTipo(String tipo)
    {
        int rta=0;
        HashSet<Entrada> auxHashSet = entradas.get(tipo);
        if (auxHashSet != null) {
            rta= auxHashSet.size();
        }
        return rta;
    }

    public int obtenerCantidadEntradasVendidasTipo(String tipo)
    {
        int vendidas = 0;
        HashSet<Entrada> entradaHashSet = entradas.get(tipo);
        if (entradaHashSet != null) {
            Iterator<Entrada> entradaIterator = entradaHashSet.iterator();
            while (entradaIterator.hasNext()) {
                if (!entradaIterator.next().isDisponibilidad()) {
                    vendidas++;
                }
            }
        }
        return vendidas;
    }

    public String devolverListadoEntradasDisponibles(String tipo)
    {
        String rta = "";
        HashSet<Entrada> entradaHashSet = entradas.get(tipo);
        Iterator<Entrada> entradaIterator = entradaHashSet.iterator();
        while (entradaIterator.hasNext())
        {
            Entrada entrada = entradaIterator.next();
            if (entrada.isDisponibilidad())
            {
                rta += entrada.toString()+"\n";
            }
        }
        return  rta;
    }

    public float devolverTotalRecaudado()
    {
        float recaudado = 0;
        Iterator<Map.Entry<String,HashSet<Entrada>>> entryIterator = entradas.entrySet().iterator();

        while (entryIterator.hasNext())//recorro el mapa, tiene dos filas
        {
            Map.Entry<String,HashSet<Entrada>> entradaMapa = entryIterator.next();
            HashSet<Entrada> entradaHashSet = entradaMapa.getValue(); //por cada fila levanto el set
            Iterator<Entrada> entradaIterator = entradaHashSet.iterator();
            while (entradaIterator.hasNext()) //recorro las entradas
            {
                Entrada entrada = entradaIterator.next(); //levanto UNA entradas
                if (!entrada.isDisponibilidad()) //si esta venida
                {
                    recaudado+=entrada.obtenerPrecioTotal(); //sumo el precio
                }
            }
        }
        return recaudado;

    }

    public boolean venderEntrada(String tipo)
    {
        boolean vendida = false;
        if (entradas.containsKey(tipo)) {
            HashSet<Entrada> entradaHashSet = entradas.get(tipo);
            int totalEntradas = entradaHashSet.size();
            int totalVendidas = obtenerCantidadEntradasVendidasTipo(tipo);

            if (totalVendidas < totalEntradas) {
                Iterator<Entrada> entradaIterator = entradaHashSet.iterator();
                while (entradaIterator.hasNext() && !vendida)  //recorro las entradas
                {
                    Entrada entrada = entradaIterator.next(); //levanto UNA entradas
                    if (entrada.isDisponibilidad()) //si esta venida
                    {
                        entrada.setDisponibilidad(false);
                        vendida = true;
                    }
                }
            }
        }
        return vendida;
    }

    public boolean isEntradasVacio(){ //devuelve true si esta vacio, false si no
       boolean rta=false;
        if(entradas.isEmpty()){
            rta=true;
        }
        return rta;
    }

    @Override
    public String toString() {
        return "Recital{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", entradas=" + entradas +
                '}';
    }

}
