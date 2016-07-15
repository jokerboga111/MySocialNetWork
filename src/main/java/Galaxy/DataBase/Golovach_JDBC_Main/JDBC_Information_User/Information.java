package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.JDBC_USER_CAREER;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.JDBC_User_Hith_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.JDBC_User_Life_Position;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.JDBC_User_service;

/**
 * Created by Admin on 10.02.2016.
 */
public class Information {
    public static void main(String[] args) throws DBSystemException {
       JDBC_USER_CAREER jdbc_user_career=new JDBC_USER_CAREER();
      jdbc_user_career.UpdatePlace_To_work("1","Data");
    }
}
