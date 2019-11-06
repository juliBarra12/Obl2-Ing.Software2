/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author juli
 */
public class Padrino {
    
    private String nombre;
    private Animal apadrinado;
    private int montoDonacion;
    private String metodoPago;
    private String moneda;
    private String frecuenciaDonacion;
    
    public Padrino(String nombre, Animal animal, int monto, String metodo, String moneda, String frecuencia){
        this.setNombre(nombre);
    }
    
    public void setNombre(String unNombre){
        nombre = unNombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setAnimalApadrinado(Animal mascota){
        apadrinado = mascota;
    }
    
    public Animal getApadrinado(){
        return apadrinado;
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
    public String toString(){
        return"Nombre del padrino: "+nombre+"\n Animal a apadrinar: "+apadrinado.getNombre()+" \n Monto a donar: "
                +montoDonacion+" en "+moneda+" "+frecuenciaDonacion+"\n El metodo de pago utilizado es: "+metodoPago+" ";
    }
    
    
}
