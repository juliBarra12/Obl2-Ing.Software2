/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import encryption.PasswordUtils;

/**
 *
 * @author lucascastro
 */
public class Funcionario {
    private String username;
    private String password;
    private String email;
    private String generatedSalt;

    
    public Funcionario(String user,String pass,String correo){
        this.username = user;
        this.generatedSalt = PasswordUtils.getSalt(30);
        this.password = PasswordUtils.generarPasswordSeguro(pass, this.generatedSalt);
        this.email = correo;
    }

    public String getEmail(){
        return this.email;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGeneratedSalt() {
        return generatedSalt;
    }
    
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setEmail(String e){
        this.email = e;
    }

    public void setPassword(String password) {
        //Guardamos el salt generado para el usuario, con el fin de poder autenticar el password 
        //ingresado en el inicio de sesion.
        this.generatedSalt = PasswordUtils.getSalt(30); 
        // Proteger el password del usuario, creamos la contraseña asegurada.
        this.password = PasswordUtils.generarPasswordSeguro(password, this.generatedSalt);
        
    }
    
    @Override
    public boolean equals(Object o){
        if (o instanceof Funcionario) {
            Funcionario func = (Funcionario) o;
            return this.username.equals(func.getUsername()) || this.email.equals(func.getEmail());
        } 
        return false;
    }
}
