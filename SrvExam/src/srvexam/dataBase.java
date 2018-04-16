package srvexam;

import java.sql.*;

public class dataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    
    public static void Conn() throws  ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:data.s3db");
        System.out.println("DONE!");
    }
}
