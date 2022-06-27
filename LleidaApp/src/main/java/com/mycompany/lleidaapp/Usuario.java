/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lleidaapp;

/**
 *
 * @author Jess
 */
public class Usuario {
    private String validuser = "sodigsa@ec";
    private String validpassword = "TIiANcmymJ";

    public Usuario() {
    }

       
    
    // revisar la validacion 
    public boolean validarUsuario (String user, String password){
        if (this.validuser.equals(user) & this.validpassword.equals(password)){
            return true;
        } else 
            return false;
    }

    public String getValiduser() {
        return validuser;
    }

    public void setValiduser(String validuser) {
        this.validuser = validuser;
    }

    public String getValidpassword() {
        return validpassword;
    }

    public void setValidpassword(String validpassword) {
        this.validpassword = validpassword;
    }
    
}
