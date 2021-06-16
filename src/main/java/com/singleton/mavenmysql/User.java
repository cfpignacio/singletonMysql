/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singleton.mavenmysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gardel
 */
public class User {
        
    static DatabaseConnection con = DatabaseConnection.getInstance();
        
        private int idUsuario;
        private String nombre;
        private String apellido;
        private int edad;

    public static void setCon(DatabaseConnection con) {
        User.con = con;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static DatabaseConnection getCon() {
        return con;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

  
      

    public static User getUser(int idUsuario) throws SQLException{
        String query = "select * from usuario where idUsuario= ?";
        if(con != null){
            PreparedStatement ps = con.getConnection().prepareStatement(query);
            ps.setInt(1, idUsuario);
            
            User u = new User();
            
            ResultSet rs = ps.executeQuery();
            
            boolean isValid = false;
            
            while (rs.next()) {
            isValid = true;
            u.idUsuario = rs.getInt("idUsuario");
            u.nombre = rs.getString("nombre");
            u.apellido = rs.getString("apellido");
            u.edad = rs.getInt("edad");
 
            }
            ps.close();
            
            if (isValid == true)
                    {
                        return u;
                    }
            
            else    {
                    return null;
                    }
        }
        
        
          return null;
        
        
       
    }
  

}
