/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projdiario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author migue
 */
public class BD {
    
     static private Connection con;
    
    public static Connection getCon() throws Exception{
        if (con == null){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DiarioDB;user=admin;password=sqlserver");
        }
        return con;
    }
    
    public static void setData(String s) throws Exception{
        BD.getCon().createStatement().executeUpdate(s);
    }
    
    public static ResultSet getData(String s)throws Exception{
        return BD.getCon().createStatement().executeQuery(s);
    }
    
}
