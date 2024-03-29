package dominio;

import java.time.LocalTime;
import javax.swing.ImageIcon;

public class Paseo extends Actividad {

    private Usuario usuario;
    private Animal mascota;
    private double distancia;
    private ImageIcon ruta;
    private boolean fueRealizado;
    private LocalTime hora;
    private Fecha fecha;
    private String nombre;

    public Paseo(String nombre, Usuario usuario, Animal mascota, double distancia, boolean fueRealizado, LocalTime hora, Fecha fecha) {
        this.usuario = usuario;
        this.mascota = mascota;
        setDistancia(distancia);
        this.fueRealizado = fueRealizado;
        this.hora = hora;
        this.fecha = fecha;
        this.ruta=null;
        setNombre(nombre);
    }
    
    public Paseo(){
        this.usuario = new Usuario();
        this.mascota = new Animal();
        this.distancia = 0;
        this.fueRealizado = false;
        this.hora = LocalTime.now();
        this.fecha = new Fecha();
        this.nombre = "Sin-Nombre";
        this.ruta=null;
    }

    public ImageIcon getRuta() {
        return ruta;
    }

    public void setRuta(ImageIcon ruta) {
        this.ruta = ruta;
    }
    
    @Override
    public LocalTime getHora() {
        return hora;
    }

    @Override
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public double getDistancia() {
        return distancia;
    }

    public final void setDistancia(double distancia) {
       if(distancia < 0){
           this.distancia = 0.0;
       }else{
           this.distancia = distancia;
       }
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(Usuario responasble) {
        this.usuario = responasble;
    }

    @Override
    public Animal getMascota() {
        return mascota;
    }

    @Override
    public void setMascota(Animal mascotas) {
        this.mascota = mascotas;
    }

    @Override
    public boolean getFueRealizado() {
        return fueRealizado;
    }

    @Override
    public void setFueRealizado(boolean seCompleto) {
        this.fueRealizado = seCompleto;
    }

    @Override
    public Fecha getFecha() {
        return fecha;
    }
    @Override
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Paseo{" + "responsable=" + usuario + ", perro=" + mascota + ", distancia=" + distancia + ", fueRealizado=" + fueRealizado + ", hora=" + hora + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }


    public final void setNombre(String nombre) {
         if(nombre.equals("")){
            this.nombre = "Sin-Nombre";
        }else{
            this.nombre = nombre;
        }
    }
}
