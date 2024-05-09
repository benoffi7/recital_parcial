import modelo.Recital;
import modelo.entradas.Entrada;
import modelo.entradas.EntradaGeneral;
import modelo.entradas.EntradaVIP;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

       Recital recital = new Recital("El recital Mas Gonzalo que el mismo Gonzalo", "03/05/24", "Santiago Del Estero");
       menu(recital);

        System.out.println(recital.toString());



    }




    public static void opcionesMenu(){
        System.out.println("""
                Ingrese 1 si desea modificar la fecha del Recital.
                Ingrese 2 si desea modificar el lugar del Recital.
                Ingrese 3 para cargar una Entrada al Recital.
                Ingrese 4 para vender una Entrada.
                Ingrese 5 para obtener la cantidad de Entradas por un tipo especifico. 
                Ingrese 6 para obtener la cantidad de Entradas vendidas por tipo
                Ingrese 7 para mostrar todas las Entradas disponibles para su venta.
                """);



    }

    public static void menu(Recital recital){
        int opSwitch=0;
        String opWhile="";
        String auxString =""; //usada para modificaciones de Strings
        int auxInt; //usada para modificaciones de int
        Entrada auxEntrada;
        do {

            opcionesMenu();
            System.out.println("Ingrese la opcion a realizar: ");
            opSwitch= scanner.nextInt();

            switch (opSwitch){
                case 1:
                    System.out.println("Ingrese la nueva fecha: ");
                    auxString= scanner.next();
                    recital.setFecha(auxString);
                    System.out.println("Nueva fecha asignada: "+recital.getFecha());
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo lugar: ");
                    auxString= scanner.next();
                    recital.setLugar(auxString);
                    System.out.println("Nuevo lugar del Recital: "+recital.getLugar());
                    break;
                case 3:
                    System.out.println("Ingrese 1 si la entrada es General, 2 si es VIP: ");
                    auxInt=scanner.nextInt();
                    if(auxInt==1){
                        System.out.println("Ingrese la zona: ");
                        auxString= scanner.next();
                        auxEntrada= new EntradaGeneral((int) (Math.random() * 1000000), auxString);
                        auxEntrada.setPrecio(500);           //PRECIO BASE PARA TODA ENTRADA= 500
                        auxEntrada.setDisponibilidad(true); //disponible para vender
                        recital.cargarEntrada(auxEntrada, auxEntrada.obtenerTipo());

                    } else if (auxInt==2){
                        System.out.println("Ingrese el beneficio: ");
                        auxString= scanner.next();
                        auxEntrada= new EntradaVIP((int) (Math.random() * 1000000),auxString);
                        auxEntrada.setPrecio(500);
                        auxEntrada.setDisponibilidad(true);
                        recital.cargarEntrada(auxEntrada, auxEntrada.obtenerTipo());

                    }else{
                        System.out.println("ERROR, asignacion invalida.."); //si elige mal..
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el tipo de entrada a vender (VIP/GENERAL): ");
                    auxString= scanner.next();
                   boolean aux= recital.venderEntrada(auxString.toUpperCase()); //el toUpper por si lo pone en minuscula
                    if(aux){
                        System.out.println("ENTRADA VENDIDA.");
                    }else{
                        System.out.println("ENTRADA NO VENDIDA.");
                    }
                    break;

                case 5:
                    System.out.println("Ingrese el tipo de entrada a buscar (VIP/GENERAL)");
                    auxString= scanner.next();
                    if(!recital.isEntradasVacio()){ //si el hashset esta vacio manda a cargar una entrada
                        auxString=auxString.toUpperCase();
                        auxInt= recital.obtenerCantidadEntradasTipo(auxString);
                        System.out.println("CANTIDAD DE ENTRADAS POR TIPO '"+auxString+"': "+auxInt);

                    }else{
                        System.out.println("ERROR, primero carga una entrada");
                    }
                    break;

                case 6:
                    if(!recital.isEntradasVacio()){

                        System.out.println("Ingrese el tipo de entrada a buscar (VIP/GENERAL)");
                        auxString= scanner.next();
                        auxInt = recital.obtenerCantidadEntradasVendidasTipo(auxString.toUpperCase());
                        System.out.println("CANTIDAD VENDIDAS DEL TIPO '"+auxString+"': "+auxInt);
                    }else{
                        System.out.println("ERROR, primero carga una entrada");
                    }
                    break;
                case 7:
                    System.out.println("Ingrese el tipo de entrada a buscar (VIP/GENERAL)");
                    auxString= scanner.next();
                    System.out.println(recital.devolverListadoEntradasDisponibles(auxString.toUpperCase()));
                    break;
                case 8:


            }

            System.out.println("Desea continuar en el sistema?(si/no)");
            opWhile= scanner.next();
        }while(opWhile.equalsIgnoreCase("si"));

    }


}