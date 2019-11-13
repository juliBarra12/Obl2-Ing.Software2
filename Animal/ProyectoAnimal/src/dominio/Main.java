package dominio;



import serialización.Persistencia;
import interfaz.VentanaRegistroLogin;

public class Main {
    public static void main(String[] args) {
        Sistema sis = new Sistema(); 
        sis = new Persistencia().deserializar("sistema.txt");
        VentanaRegistroLogin ventana = new VentanaRegistroLogin(sis);
        ventana.inicializarVentana();
       
    } 
}
