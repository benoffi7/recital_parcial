import modelo.PartidoFutbol;
import modelo.Recital;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGeneral;
import modelo.entradas.EntradaVIP;
import modelo.interfaces.IControlPublico;
import modelo.interfaces.IVentaEntradas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int ultimoID;
    static Scanner scanner1;

    public static void main(String[] args) {
        scanner1 = new Scanner(System.in);

        /// #1: Sistema de entradas
        Recital reci1 = new Recital("Tributo a The Beatles ft. Fabian Cubero", "10-may-2024", "El Fortin");

        // Las entradas como tal
        Entrada entrada1 = new EntradaGeneral(generarID(), "codo");
        Entrada entrada2 = new EntradaVIP(generarID(), "CD con el recital grabado (volvimos a los 90)");
        Entrada entrada3 = new EntradaGeneral(generarID(), "platea");

        // Entradas automatizadas
        asisCargarMuchasEntradas(reci1);

    }

    public static void asisCargarMuchasEntradas(Recital eventoDestino)
    {
        // por implementar
    }

    public static void asisCargarUnaEntrada(Recital eventoDestino) {
        String tipoEntrada;
        Entrada entradaTmp = null; // la usaremos mas tarde: con null y no basura asi es reconocida luego
        String zonaTmp;
        boolean tipoCorrecto = true; // las necesito en true para acceder mejor a la condicion
        boolean zonaCorrecta = true;
        boolean respuesta = false;

        // Primer paso: preguntar el tipo de entrada
        do {
            System.out.println("Seleccione el tipo de entrada que quiere: 'general' o 'vip'");
            tipoEntrada = scanner1.nextLine().toLowerCase();

            // Comprobamos que el usuario use bien el cerebro y haya puesto bien el nombre
            if (!(tipoEntrada.equals("general") || tipoEntrada.equals("vip"))) {
                System.out.println("Incorrecto. Intentalo de nuevo");
                tipoCorrecto = false;
            }

        } while (!tipoCorrecto);

        // Segundo paso: preguntar la zona en el caso de que sea general (o vip)
        if (tipoEntrada.equals("general"))
        {
            do {
                System.out.println("Intoduzca que zona quiere: 'platea', 'campo' o 'codo'");
                zonaTmp = scanner1.nextLine().toLowerCase();

                if (!(zonaTmp.equals("platea") || zonaTmp.equals("campo") || zonaTmp.equals("codo"))) {
                    System.out.println("Incorrecto. Intentalo de nuevo");
                    zonaCorrecta = false;
                }
            } while (!zonaCorrecta);

            entradaTmp = new EntradaGeneral(generarID(), zonaTmp);
        }
        else if (tipoEntrada.equals("vip"))
        {
            entradaTmp = new EntradaVIP(generarID(), "CD con el recital grabado (volvimos a los 90)");
        }

        respuesta = eventoDestino.cargarEntrada(entradaTmp, tipoEntrada);

        // Comprobamos si se cargo
        if(respuesta)
        {
            System.out.println("Cargado correctamente");
            System.out.println(entradaTmp.toString());
        }

    }


    // Generacion de ID: es un static por lo que por puntero lo modifico
    public static int generarID() {
        ultimoID++;
        return ultimoID;
    }
}