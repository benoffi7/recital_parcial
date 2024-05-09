import modelo.PartidoFutbol;
import modelo.Recital;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGeneral;
import modelo.entradas.EntradaVIP;
import modelo.interfaces.IControlPublico;
import modelo.interfaces.IVentaEntradas;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    static int ultimoID;

    public static void main(String[] args) {
        /// #1: Sistema de entradas
        Recital reci1 = new Recital("Tributo a The Beatles ft. Fabian Cubero", "10-may-2024", "El Fortin");

        // Las entradas como tal
        Entrada entrada1 = new EntradaGeneral(generarID(), "codo");
        Entrada entrada2 = new EntradaVIP(generarID(), "CD con el recital grabado (volvimos a los 90)");
        Entrada entrada3 = new EntradaGeneral(generarID(), "platea");
    }



    

    // Generacion de ID: es un static por lo que por puntero lo modifico
    public static int generarID()
    {
        ultimoID++;
        return ultimoID;
    }
}