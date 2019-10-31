package dominio;

import java.time.LocalTime;

public abstract class Actividad {

    
    private Animal mascota;
    private boolean fueRealizado;
    private Fecha fecha;
    private LocalTime hora;
    private String nombre;

    public abstract String getNombre();

    public abstract LocalTime getHora();

    public abstract void setHora(LocalTime hora);

    public abstract Usuario getUsuario();

    public abstract void setUsuario(Usuario responasble);

    public abstract Animal getMascota();

    public abstract void setMascota(Animal mascota);

    public abstract boolean getFueRealizado();

    public abstract void setFueRealizado(boolean seCompleto);

    public abstract Fecha getFecha();

    public abstract void setFecha(Fecha fecha);
}
