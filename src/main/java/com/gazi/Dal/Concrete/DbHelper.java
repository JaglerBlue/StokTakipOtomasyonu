/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Dal.Concrete;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbHelper {
    
    private final String userName="root";
    private final String password = "123qq";
    private final String dbUrl = "jdbc:mysql://localhost/stock?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl,userName,password);
    }
    
    public void showErrorMessage(SQLException exception){
        System.out.println("Error : " + exception.getMessage());
        System.out.println("Error code : "+ exception.getErrorCode());
    }
    
}