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
    private String generatedSalt;

    
    public Funcionario(String user,String pass){
        this.username = user;
        this.password = pass;
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

    public void setPassword(String password) {
        // Generar salt para luego encriptar el password del usuario.
        String salt = PasswordUtils.getSalt(30);
        //Guardamos el salt generado para el usuario, con el fin de poder autenticar el password 
        //ingresado en el inicio de sesion.
        this.generatedSalt = salt;
        // Proteger el password del usuario
        String passwordEncriptado = PasswordUtils.generateSecurePassword(password, salt);
        this.password = passwordEncriptado;
    }
    
    
}
