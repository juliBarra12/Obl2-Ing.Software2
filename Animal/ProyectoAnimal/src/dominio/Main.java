package dominio;



import serializacion.Persistencia;
import interfaz.VentanaRegistroLogin;

public class Main {
    public static void main(String[] args) {
        Sistema sis = new Persistencia().deserializar("sistema.txt");
        VentanaRegistroLogin ventana = new VentanaRegistroLogin(sis);
        ventana.inicializarVentana();
       
    } 
}
