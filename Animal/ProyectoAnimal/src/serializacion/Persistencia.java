/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import dominio.Sistema;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author lucascastro
 */
public class Persistencia {
    
    private FileInputStream inputArchivo;
    private FileOutputStream archivoGrabacion;
    
    
    public Persistencia(){
        
    }
    
    public Persistencia(Object o){
        this.serializar(o);
    }
    public Persistencia(String archivo){
        this.deserializar(archivo);
    }
    
        public void serializar(Object obj) {
        String archivo = "";
        this.archivoGrabacion = null;
        ObjectOutputStream out = null;

        if (obj instanceof Sistema) {
            archivo = "sistema.txt";
        }

        try {
            archivoGrabacion = new FileOutputStream(archivo);
            out = new ObjectOutputStream(archivoGrabacion);
            out.writeObject(obj);
            System.out.println("Sistema serializado correctamente"); 
        } catch (IOException e) {
            System.out.println("No pudo escribir");
            
        } finally {

            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    System.out.println("error al cerrar ObjectWriter");
                }
            }

            if (archivoGrabacion != null) {
                try {
                    archivoGrabacion.flush();
                    archivoGrabacion.close();
                } catch (IOException e) {
                    System.out.println("error al cerrar archivo");
                }
            }

        }
    }
    
    public Sistema deserializar(String archivo) {
    
        this.inputArchivo = null;
        ObjectInputStream in = null;
        Sistema retorno = new Sistema();
        
        try {
             inputArchivo = new FileInputStream(archivo);
             in = new ObjectInputStream(inputArchivo);
             
             
             retorno = (Sistema)in.readObject();
             System.out.println("Sistema deserializado correctamente");
        } catch(IOException e) {
            System.out.println("No se pudo leer");
            
        }
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        }
        finally {
        
            if (inputArchivo != null) {
                try {
                    
                    inputArchivo.close();
                } catch (IOException e) {
                    System.out.println("error al cerrar archivo");
                }
            }

            if (in != null) {
                try {
                    
                    in.close();
                } catch (IOException e) {
                    System.out.println("error al cerrar lector");
                }
            }
        
        }
  
     return retorno;   
    }
}
