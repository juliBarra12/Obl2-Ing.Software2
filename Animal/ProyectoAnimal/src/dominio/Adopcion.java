/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author juli
 */
public class Adopcion implements Serializable{
    
    private String nombre;
    private String apellido;
    private int telefono;
    private Animal mascota;
    
    public Adopcion (String nombre, String apellido, int telefono, Animal animal){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mascota = animal;
        animal.adoptar();
    }
    
    public void setNombreAdoptante(String unNombre){
        nombre = unNombre;
    }
    
    public String getNombreAdoptante(){
        return nombre;
    }
    
    public void setApellidoAdoptante(String unApellido){
        apellido = unApellido;
    }
    
    public String getApellidoAdoptante(){
        return apellido;
    }
    
    
    public void setTelefono(int unTelefono){
        telefono = unTelefono;
    }
    
    public int getTelefono(){
        return telefono;
    }
    
    public void setAnimal(Animal animal){
        mascota = animal;
    }
    
    public Animal getAnimal(){
        return mascota;
    }
    
    
    @Override
    public String toString(){
        return this.nombre+" "+this.apellido;
    }
    
    
}
