import modelo.entradas.Entrada;
import modelo.entradas.EntradaGeneral;
import modelo.entradas.EntradaVIP;

public class Main {
    public static void main(String[] args) {

        EntradaGeneral entrada = new EntradaGeneral(1,"codo");
        entrada.obtenerPrecioTotal();

        Entrada entradaVIP = new EntradaVIP(2,"wifi");
        entradaVIP.obtenerPrecioTotal();


    }



}