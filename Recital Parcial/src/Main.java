import modelo.entradas.Entrada;
import modelo.entradas.EntradaGeneral;
import modelo.entradas.EntradaVIP;

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


    }
}