package srvexam;

import java.sql.*;
import sq

public class dataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    
    public static void Conn() throws  ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Irbis/Desktop/exam/SrvExam/data.s3db");
    }
    
    public static void Close() throws ClassNotFoundException, SQLException{
        conn.close();
        statmt.close();
        resSet.close();
    }
    
    public static void addNewUser(String FIO, String login, String passwd) throws ClassNotFoundException, SQLException{
        Conn();
        statmt.execute("INSERT INTO 'users' ('FIO', 'login', 'password')VALUES('"+FIO+"', '"+login+"', '"+passwd+"');");
        Close();
    }
}
