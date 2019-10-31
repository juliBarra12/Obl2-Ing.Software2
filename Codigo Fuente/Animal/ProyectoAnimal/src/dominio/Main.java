package dominio;


import interfaz.VentanaLogin;
import interfaz.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        Sistema sis = new Sistema();
        VentanaLogin ventana = new VentanaLogin();
        ventana.setVisible(true);
    } 
}
