package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service;

/**
 * Created by Admin on 17.02.2016.
 */
public class test {
    public static void main(String[] args) throws DBSystemException {
        Dao_Ather_Service fer=new JDBC_Ather_Service();
        System.out.println(fer.SelectUserAther_Service("1").toString());
    }
}
