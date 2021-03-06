package srvexam;

import frames.groupsFrame;
import frames.usersFrame;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class dataBase {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    
    public static void Conn() throws  ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Irbis/Desktop/exam/SrvExam/src/srvexam/data.s3db");
    }
    
    public static void Close() throws ClassNotFoundException, SQLException{
        conn.close();
        statmt.close();
        resSet.close();
    }
    
    public static void addNewUser(String FIO, String login, String passwd) throws ClassNotFoundException, SQLException{
        Conn();
        statmt = conn.createStatement();
        statmt.execute("INSERT INTO 'users' ('FIO', 'login', 'password')VALUES('"+FIO+"', '"+login+"', '"+passwd+"');");
        Close();
    }
    
    public static void refreshUsersFrame() throws ClassNotFoundException, SQLException{
        Conn();        
        DefaultTableModel dtm = (DefaultTableModel)usersFrame.jTable1.getModel();
        Vector header = new Vector();
        header.add("ФИО");
        header.add("login");
        Vector data = new Vector();
        dtm.setDataVector(data, header); 
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM users;");
        while(resSet.next()){
            Vector str = new Vector();
            String FIO = resSet.getString("FIO");
            String login = resSet.getString("login");
            str.add(FIO);
            str.add(login);
            data.add(str);
        } 
        Close();
    }
    
    public static void deleteUser(String login) throws ClassNotFoundException, SQLException{
        Conn();
        statmt = conn.createStatement();
        statmt.execute("DELETE FROM users WHERE login = '"+login+"';");
        Close();
    }
    
    public static void refreshUserData(String FIO, String login, String oldLogin) throws ClassNotFoundException, SQLException{
        Conn();
        statmt = conn.createStatement();
        statmt.executeUpdate("UPDATE users SET FIO = '"+FIO+"', login = '"+login+"' WHERE login = '"+oldLogin+"';");
        Close();        
    }
    
    public static void addNewGroup(String name) throws ClassNotFoundException, SQLException {
        Conn();
        statmt = conn.createStatement();
        statmt.execute("INSERT INTO 'groups'('name')VALUES('"+name+"');");
        Close();
    }
    
    public static void refreshGroupFrame() throws ClassNotFoundException, SQLException {
       Conn();
       DefaultTableModel dtm = (DefaultTableModel)groupsFrame.jTable1.getModel();
       Vector header = new Vector();
       header.add("Название");
       Vector data = new Vector();
       dtm.setDataVector(data, header);
       statmt = conn.createStatement();
       resSet = statmt.executeQuery("SELECT * FROM groups");
       while(resSet.next()){
           Vector str = new Vector();
           String name = resSet.getString("name");
           str.add(name);
           data.add(str);
       }
       Close();
    }
    
    public static void deleteGroup(String name) throws ClassNotFoundException, SQLException {
        Conn();
        statmt = conn.createStatement();
        statmt.execute("DELETE FROM groups WHERE name = '"+name+"';");
        Close();
    }
    
    public static void refreshGroup() throws ClassNotFoundException, SQLException {
        Conn();
        
        Close();
    }
}