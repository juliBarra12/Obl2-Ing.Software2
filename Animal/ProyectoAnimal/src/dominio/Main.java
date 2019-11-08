package dominio;



import interfaz.VentanaPrincipal;
import interfaz.VentanaRegistroLogin;

public class Main {
    public static void main(String[] args) {
        Sistema sis = new Sistema();
        sis = sis.deserializar("sistema.txt");
        VentanaRegistroLogin ventana = new VentanaRegistroLogin(sis);
        ventana.inicializarVentana();
       
    } 
}
