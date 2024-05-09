import modelo.Recital;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

       Recital Recital = new Recital("El recital Mas Gonzalo que el mismo Gonzalo", "03/05/24", "Santiago Del Estero");
       // opcionesMenu();





    }




    public static void opcionesMenu(){
        System.out.println("""
                Ingrese 1 si desea modificar la fecha del Recital
                Ingrese 2 si desea modificar el lugar del Recital
                """);



    }

    public static void menu(Recital recital){
        int opSwitch=0;
        String opWhile="";
        String auxString =""; //usada para modificaciones de Strings
        do {

            switch (opSwitch){
                case 1:
                    auxString= scanner.next();
                    recital.setFecha(auxString);
                    System.out.println("Nueva fecha asignada: "+recital.getFecha());
                    break;
                case 2:
                    auxString= scanner.next();
                    recital.setLugar(auxString);
                    System.out.println("Nuevo lugar del Recital: "+recital.getLugar());
                    break;
                case 3:


            }

            System.out.println("Desea continuar en el sistema?(si/no)");
            opWhile= scanner.next();
        }while(opWhile.equalsIgnoreCase("si"));

    }


}