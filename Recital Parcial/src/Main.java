import modelo.PartidoFutbol;
import modelo.Recital;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGeneral;
import modelo.entradas.EntradaVIP;
import modelo.interfaces.IControlPublico;
import modelo.interfaces.IVentaEntradas;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        EntradaGeneral entrada = new EntradaGeneral(1,"codo");
        entrada.obtenerPrecioTotal();

        Entrada entradaVIP = new EntradaVIP(2,"wifi");
        entradaVIP.obtenerPrecioTotal();


        ArrayList<IVentaEntradas> iVentaEntradas = new ArrayList<>();
        iVentaEntradas.add(new Recital());
        iVentaEntradas.add(new PartidoFutbol());

        venderEntradas(new Recital());

        venderEntradas(new PartidoFutbol());
        controlPublico(new PartidoFutbol());

       // getEntrada(new EntradaGeneral());
       // getEntrada(new EntradaVIP());



    }

    public static void venderEntradas (IVentaEntradas iVentaEntradas)
    {
    //soy un cambio de la rama
    }

    public static void controlPublico (IControlPublico iControlPublico)
    {

    }



    public static void getEntrada(Entrada entrada)
    {

    }
}