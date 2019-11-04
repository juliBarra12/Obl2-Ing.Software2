package dominio;



import interfaz.VentanaPrincipal;
import interfaz.VentanaRegistroLogin;

public class Main {
    public static void main(String[] args) {
        Sistema sis = new Sistema();
        VentanaRegistroLogin ventana = new VentanaRegistroLogin();
        ventana.inicializarVentana();
        /*VentanaPrincipal vent = new VentanaPrincipal(sis);
        vent.setVisible(true);*/
    } 
}
