/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singleton.mavenmysql;
import java.sql.*;

/**
 *
 * @author Gardel
 */
public class main {
    public static void main(String[] args) throws SQLException {
        
        User u = User.getUser(554);
        if(u == null){
            System.out.println("USUARIO NO ENCONTRADO");
            System.exit(0);
        }
        
        System.out.println("IDUSUARIO: " + u.getIdUsuario());
        System.out.println("NOMBRE: " + u.getNombre());
        System.out.println("APELLIDO: " + u.getApellido());
        System.out.println("EDAD: " + u.getEdad());
        
   
        
        
    }
}
