package dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.ImageIcon;

public class Animal implements Serializable {

    private String nombre;
    private double altura;
    private double peso;
    private String comentarios;
    private ImageIcon foto;
    private boolean adoptado;
    private String tipo;

    public Animal(String nombre, String tipo, double altura, double peso, String comentarios) { //Sin foto
        setNombre(nombre);
        setAltura(altura);
        setPeso(peso);
        setComentarios(comentarios);
        this.foto = null;
        this.adoptado = false;
        setTipo(tipo);
    }
    public String estadoAdopcion(){
        if (this.adoptado) return "ANIMAL ADOPTADO";
        return "ANIMAL SIN ADOPTAR";
        
    }
    public Animal() { //Sin foto
        this.nombre = "Sin-Nombre";
        this.altura = 0;
        this.peso = 0;
        this.comentarios = "Sin-Comentarios";
        this.foto = null;
        this.tipo = "";
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre.equals("")) {
            this.nombre = "Sin-Nombre";
        } else {
            this.nombre = nombre;
        }

    }

    public double getAltura() {
        return altura;
    }

    public final void setAltura(double altura) {
        if (altura < 0) {
            this.altura = 0.0;
        } else {
            this.altura = altura;
        }

    }

    public double getPeso() {
        return peso;
    }

    public final void setPeso(double peso) {
        if (peso < 0) {
            this.peso = 0.0;
        } else {
            this.peso = peso;
        }
    }

    public String getComentarios() {
        return comentarios;
    }

    public final void setComentarios(String comentarios) {
        if (comentarios.equals("")) {
            this.comentarios = "Sin-Comentarios";

        } else {
            this.comentarios = comentarios;
        }
    }

    public ImageIcon getFoto() {
        return foto;
    }

    public void setFoto(ImageIcon imagen) {
        this.foto = imagen;
    }
    
    public void adoptar(){
        this.adoptado = true;
    }
    
    public boolean estaAdoptado(){
        return adoptado;
    }
    
    public void setTipo(String elTipo){
        tipo = elTipo;
    }
    
    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
     public boolean equals(Object o){
         Animal ani = null;
         if(o instanceof Animal){
             ani = (Animal)o;
         }else{
             return false;
         }
         return this.nombre.equals(ani.getNombre());
     }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    

}
