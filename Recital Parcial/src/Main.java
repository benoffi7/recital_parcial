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

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Recital recital = new Recital();

        System.out.println("Bienvenido al Recital 'El Recital más Gonzalo del Mundo Mundial'");

        while (true) {
            System.out.println("\nPor favor, elija una opción:");
            System.out.println("1. Ver información del recital");
            System.out.println("2. Cargar entrada");
            System.out.println("3. Mostrar cantidad de entradas disponibles");
            System.out.println("4. Mostrar total recaudado");
            System.out.println("5. Vender entrada");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("\nInformación del recital:");
                    System.out.println("Nombre: " + recital.getNombre());
                    System.out.println("Fecha: " + recital.getFecha());
                    System.out.println("Lugar: " + recital.getLugar());
                    break;
                case 2:
                    System.out.println("\nCargar una entrada:");
                    System.out.println("Por favor, ingrese el tipo de entrada (VIP o GENERAL):");
                    String tipo = scanner.nextLine();
                    System.out.println("Ingrese el ID de la entrada:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if(!recital.existeEntradaConId(id)) {
                        Entrada entrada;
                        if (tipo.equalsIgnoreCase("VIP")) {
                            System.out.println("Ingrese el beneficio de la entrada VIP:");
                            String beneficio = scanner.nextLine();
                            entrada = new EntradaVIP(id, beneficio);
                        } else if (tipo.equalsIgnoreCase("GENERAL")) {
                            System.out.println("Ingrese la zona de la entrada general:");
                            String zona = scanner.nextLine();
                            entrada = new EntradaGeneral(id, zona);
                        } else {
                            System.out.println("Tipo de entrada no válido. Selecciona 'VIP' o 'GENERAL'.");
                            continue;
                        }
                        recital.cargarEntrada(entrada, tipo);
                        System.out.println("Entrada cargada con éxito.");
                    }else{
                        System.out.println("Ya existe una entrada con ese ID.");
                    }
                    break;
                case 3:
                    System.out.println("\nCantidad de entradas disponibles:");
                    System.out.println("VIP: " + recital.obtenerCantidadEntradasTipo("VIP"));
                    System.out.println("GENERAL: " + recital.obtenerCantidadEntradasTipo("GENERAL"));
                    break;
                case 4:
                    System.out.println("\nTotal recaudado: $" + recital.devolverTotalRecaudado());
                    break;
                case 5:
                    System.out.println("\nVender una entrada:");
                    System.out.println("Por favor, ingrese el tipo de entrada (VIP o GENERAL):");
                    String tipoEntrada = scanner.nextLine();

                    boolean entradaVendida = recital.venderEntrada(tipoEntrada);
                    if (entradaVendida) {
                        System.out.println("¡Entrada vendida con éxito!");
                    } else {
                        System.out.println("No hay entradas disponibles de ese tipo.");
                    }
                    break;
                case 6:
                    System.out.println("¡Gracias por visitar el Recital 'El Recital más Gonzalo del Mundo Mundial'!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 5.");
                    break;
            }
        }


    }

}