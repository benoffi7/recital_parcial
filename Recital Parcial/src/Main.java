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

        /*
        // Las entradas como tal
        Entrada entrada1 = new EntradaGeneral(generarID(), "codo");
        Entrada entrada2 = new EntradaVIP(generarID(), "CD con el recital grabado (volvimos a los 90)");
        Entrada entrada3 = new EntradaGeneral(generarID(), "platea");
        */

        // Entradas automatizadas
        char decision = 's';
        int opcion;

        while(decision == 's')
        {
            System.out.println("1. (ADMIN) Cargar entradas al sistema");
            System.out.println("2. (USER) Comprar entradas del sistema");
            System.out.print("Su decision: ");
            opcion = scanner1.nextInt();

            switch (opcion) {
                case 1:
                    asisCargarMuchasEntradas(reci1);
                    break;
                case 2:
                    asisComprarMuchasEntradas(reci1);
                    break;
                default:
                    System.out.println("Incorrecto");
                    break;
            }
            System.out.print("Seguir ejecutando todo el programa? (s/n): ");
            decision = scanner1.next().charAt(0);
        }


    }

    /// CARGAR ENTRADAS PARA LA POSTERIOR VENTA //////////


    public static void asisCargarMuchasEntradas(Recital eventoDestino)
    {
        char decision = 's';
        while (decision == 's')
        {
            System.out.println("----------------------------");
            asisCargarUnaEntrada(eventoDestino);
            System.out.println("----------------------------");
            System.out.print("Desea seguir cargando? (s/n): ");
            decision = scanner1.next().charAt(0);
        }
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
            scanner1.nextLine();
            tipoEntrada = scanner1.nextLine().toLowerCase();

            // Comprobamos que el usuario use bien el cerebro y haya puesto bien el nombre
            if (!(tipoEntrada.equals("general") || tipoEntrada.equals("vip"))) {
                System.out.println("Incorrecto. Intentalo de nuevo");
                System.out.println("Entrada del usuario: '" + tipoEntrada + "'");
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
        else
        {
            System.out.println("Error en la carga de entrada");
        }

    }

    /// VENTA DE ENTRADAS YA CARGADAS //////////

    public static void asisComprarMuchasEntradas(Recital eventoDestino)
    {
        char decision = 's';
        while (decision == 's')
        {
            System.out.println("----------------------------");
            asisComprarUnaEntrada(eventoDestino);
            System.out.println("----------------------------");
            System.out.print("Desea seguir comprando? (s/n): ");
            decision = scanner1.next().charAt(0);
        }
    }

    public static void asisComprarUnaEntrada(Recital eventoDestino)
    {
        String tipoEntrada;
        String zonaTmp;
        boolean tipoCorrecto = true; // las necesito en true para acceder mejor a la condicion
        boolean zonaCorrecta = true;
        boolean respuesta = false;

        // Primer paso: preguntar el tipo de entrada
        do {
            System.out.println("Seleccione el tipo de entrada que quiere: 'general' o 'vip'");
            scanner1.nextLine();
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
                scanner1.nextLine();
                zonaTmp = scanner1.nextLine().toLowerCase();

                if (!(zonaTmp.equals("platea") || zonaTmp.equals("campo") || zonaTmp.equals("codo"))) {
                    System.out.println("Incorrecto. Intentalo de nuevo");
                    zonaCorrecta = false;
                }
            } while (!zonaCorrecta);

        }
        else if (tipoEntrada.equals("vip"))
        {
            System.out.println("Por motivos economicos del club le podemos ofrecer un CD con la grabacion del recital");
        }

        // No se vende: la teoria es que nunca le llega al back la zona que estamos comprando

        respuesta = eventoDestino.venderEntrada(tipoEntrada);

        // Comprobamos si se cargo
        if(respuesta)
        {
            System.out.println("Vendida correctamente, imprimiendo comprobante");
        }
        else
        {
            System.out.println("Error en la compra de la entrada");
            System.out.println(tipoEntrada);
        }
    }


    // Generacion de ID: es un static el attr. por lo que por puntero lo modifico
    public static int generarID() {
        ultimoID++;
        return ultimoID;
    }
}