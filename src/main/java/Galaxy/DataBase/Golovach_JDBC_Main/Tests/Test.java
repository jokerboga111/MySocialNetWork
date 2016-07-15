package Galaxy.DataBase.Golovach_JDBC_Main.Tests;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroups;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.DaoGroupsJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.Dao_Upravlenye_Group;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group.JDBC_Upravlenye_Group;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.JDBC_Contact_Info;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.JDBC_USER_CAREER;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.JDBC_User_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.Dao_User_Hith_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education.JDBC_User_Hith_Education;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Dao_Informaion_User;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.JDBC_InformationUser;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.JDBC_User_Life_Position;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service.JDBC_User_service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage.DaoMassage;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage.DaoMassageJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page.JDBC_ather_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.JDBC_Change_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.JDBC_Change_Id;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.JDBC_Moment_Opovechenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page.JDBC_My_page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.JDBC_Opoveshenie_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.JDBC_Option_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.JDBC_Svyazi_so_mnoy;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.JDBC_Zapisi_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.JDBC_Wall;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena.Wall;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.DataBase.Golovach_JDBC_Main.PatterDao.PatterDao;

import Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.UserAccount.User;

import java.util.List;

/**
 * Created by Admin on 13.12.2015.
 */
public class Test {
    public static void main(String[] args) throws DBSystemException, NotUniqueUserEmailException, NotUniqueUserLoginException {
        JDBC_Change_Id moment_opovechenye= new JDBC_Change_Id();
        moment_opovechenye.inserIdREgister("4");


    }


}