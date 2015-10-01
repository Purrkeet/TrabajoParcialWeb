package pe.edu.upc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database 
{
    static String hostname = "localhost";
    static String port = "3306";
    static String database = "dbnoticias"; 
    static String username = "root";
    static String password = "root";
    static String databaseVendor = "MySQL";
    static String jndi="java:jboss/datasources/ExampleJASS";

    public Database() 
    {

    }

    public static Connection getConnection() throws SQLException
    {
        if (databaseVendor.equals("MySQL"))
        {
           return getConnectionMySQL(); 
        } 
        
        else if (databaseVendor.equals("Oracle")) 
        {
            return getConnectionOracle();
        } 
        
        else 
        {
            return null;
        }
    }

    public static Connection getConnectionOracle() throws SQLException 
    {
        Connection conn = null;
        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + database;
        conn = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Conexion con exito!");
        return conn;
    }

    public static Connection getConnectionMySQL() throws SQLException
    {
        Connection conn = null;
        //jdbc:mysql://localhost:3306/dbnoticias
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
        conn = DriverManager.getConnection(jdbcUrl, username, password);
        System.out.println("Conexion con exito!");
        return conn;
    }
}
