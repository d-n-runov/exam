package srvexam;

import java.sql.*;

public class dataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    
    public static void Conn() throws  ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Irbis/Desktop/exam/SrvExam/src/srvexam/data.s3db");
        System.out.println("DONE!");
    }
    
    public static void Close() throws ClassNotFoundException, SQLException{
        conn.close();
        statmt.close();
        resSet.close();
        System.out.println("Close");
    }
    
    public static void addNewUser(String FIO, String login, String passwd) throws ClassNotFoundException, SQLException{
        Conn();
        statmt = conn.createStatement();
        statmt.execute("INSERT INTO 'users' ('FIO', 'login', 'password')VALUES('"+FIO+"', '"+login+"', '"+passwd+"');");
        System.out.println("Success");
        Close();
    }
    
    public static void getUsers() throws ClassNotFoundException, SQLException{
        
    }
}
