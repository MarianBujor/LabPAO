package com.company;
import java.sql.*;
public class JBDCTransport
{
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.transport";
    static final String DB_URL = "jdbc:mysql://localhost:3306/transport";
    static final String USER = "root";
    static final String PASS = "";
    public static void Tabel_nou()
    {
        try
        {

            //Class.forName(JDBC_DRIVER);
            Connection conn;
            Statement stmt;

            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            stmt = conn.createStatement();

           // String sql = "CREATE TABLE `transport`.`soferi` ( `id` INT(2) NOT NULL , `varsta` INT(2) NOT NULL , `vechime` INT(2) NOT NULL , `nume` VARCHAR(255) NOT NULL )";
           // String sql = "CREATE TABLE `transport`.`masini` ( `tip` VARCHAR(255) NOT NULL , `consum` VARCHAR(255) NOT NULL , `marca` VARCHAR(255) NOT NULL , `nr_inmatriculare` VARCHAR(255) NOT NULL )";
            //String sql = "CREATE TABLE `transport`.`rute` ( `plecare` VARCHAR(255) NOT NULL , `destinatie` VARCHAR(255) NOT NULL )";
            String sql ="CREATE TABLE `transport`.`candidati` ( `vechime` INT(2) NOT NULL , `nume` VARCHAR(255) NOT NULL , `categorie_permis` VARCHAR(255) NOT NULL )";
            stmt.executeUpdate(sql);
            System.out.println("Tabelul a fost creat");
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static Connection getDBConnection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeDBConnection(Connection conn)
    {
        try
        {
            if (conn != null)
            {
                conn.close();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
