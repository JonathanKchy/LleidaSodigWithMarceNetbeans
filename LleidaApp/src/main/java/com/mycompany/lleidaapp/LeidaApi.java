/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lleidaapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Jess
 */
public class LeidaApi {
    public static HttpsURLConnection conn = null; // Instaciar Conexión 
    public static URL url = null; // Instanciar la url 
    public static String cabecera= "https://tsa.lleida.net/cgi-bin/mailcertapi.cgi?action=";

    
    
        
   
    public  URL construirURL(String action , String user ,String password, String min , String max) throws MalformedURLException{
  
     String consulta = LeidaApi.cabecera + action+"&user="+ user+"&password=" + 
             password+"&mail_date_min="+min+"&mail_date_max="+max ;
      
     URL url= new URL(consulta); 
        return url;
        
    }
    
    public  HttpsURLConnection getConnection(URL url) throws ProtocolException, IOException{
        HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        return conn;
    } 

    // Verificar la conexion con la API 
    public boolean verificarConnection( HttpsURLConnection conn) throws IOException{
        try{
            int responseCod= conn.getResponseCode();
            if (responseCod==200);
            System.out.println("Conexion Establecida");
            return true;
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
            System.out.println("Conexion Fallida, Contactarse con Administrador de Api");
            return false;
        }
       
    }
}
