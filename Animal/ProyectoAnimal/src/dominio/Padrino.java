/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author juli
 */
public class Padrino implements Serializable {
    
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private String ciudad;
    private String pais;
    private ArrayList<Animal> apadrinados;
    private int montoDonacion;
    private String metodoPago;
    private String moneda;
    private String frecuenciaDonacion;
    
    public Padrino(String nombre, String apellido, int telefono, String email, String ciudad, String pais, int monto, String metodo, String moneda, String frecuencia) {
        setNombre(nombre);
        setApellido(apellido);
        setTelefono(telefono);
        setEmail(email);
        setCiudad(ciudad);
        setPais(pais);
        setMonto(monto);
        setMetodoPago(metodo);
        setMoneda(moneda);
        setFrecuencia(frecuencia);
        this.apadrinados = new ArrayList<>();
    }
    
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setApellido(String elApellido){
        apellido = elApellido;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setTelefono(int elTelefono){
        telefono = elTelefono;
    }
    
    public int getTelefono(){
        return telefono;
    }
    
    public void setEmail(String elEmail){
        email = elEmail;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setCiudad(String laCiudad){
        ciudad = laCiudad;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public void setPais(String elPais){
        pais = elPais;
    }
    
    public String getPais(){
        return pais;
    }
    
    public void addAnimalApadrinado(Animal mascota){
        apadrinados.add(mascota);
    }
    
    public ArrayList<Animal> getApadrinados(){
        return apadrinados;
    }

    public void setApadrinados(ArrayList<Animal> apadrinados) {
        this.apadrinados = apadrinados;
    }
    
    public void setMonto(int monto){
        montoDonacion = monto;
    }
    
    public int getMonto(){
        return montoDonacion;
    }
    
    public void setMetodoPago(String metodo){
        metodoPago = metodo;
    }
    
    public String getMetodo(){
        return metodoPago;
    }
    
    public void setMoneda(String unaMoneda){
        moneda = unaMoneda;
    }
    
    public String getMoneda(){
        return moneda;
    }
    
    public void setFrecuencia(String frecuencia){
        frecuenciaDonacion = frecuencia;
    }
    
    public String getFrecuencia(){
        return frecuenciaDonacion;
    }
    
    @Override
    //Agregar los animales apadrinados
    public String toString(){
        return this.nombre;
    }
    
    
}
