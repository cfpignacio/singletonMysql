/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.singleton.mavenmysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Gardel
 */
public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private Connection con;
    private String host = "jdbc:mysql://localhost:3306/usuarios_db";
    private String username = "root";
    private String password = "1234"; 
    
    
    private DatabaseConnection()
    {
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           this.con = DriverManager.getConnection(host,username,password);
           System.out.println("BASE DE DATOS ON"); 
        } catch (Exception e)
        {
            System.out.println("ERROR ->" + e);
        }
        
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public static DatabaseConnection getInstance() {
        try{
                if (instance == null) {
                instance = new DatabaseConnection();

                } else if (instance.getConnection().isClosed()) {
                    instance = new DatabaseConnection();
                }

            return instance;
        } 
        
        catch(SQLException e){
            
            return instance;
            
        }
    
    }
}
