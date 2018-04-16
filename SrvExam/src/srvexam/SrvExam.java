package srvexam;

import frames.groupsFrame;
import frames.mainFrame;
import frames.questionsFrame;
import frames.usersFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SrvExam {
    public static void main(String[] args) {
        try {
            dataBase.Conn();
            mainFrame.main();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SrvExam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SrvExam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void callFrames(String nameFrame) {
        int k = 0;
        switch(nameFrame){
            case "usersFrame":
                if(usersFrame.init == 0){
                    usersFrame.main();
                    usersFrame.init = 1;
                }
                break;
            case "groupsFrame":
                if(groupsFrame.init == 0){
                    groupsFrame.main();
                    groupsFrame.init = 1;
                }
                break;
            case "questionsFrame":
                if(questionsFrame.init == 0){
                    questionsFrame.main();
                    questionsFrame.init = 1;
                }
                break;
        }
    }
}
