package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_ather_page {

    public void Update_who_can_see_my_page(String id,String New_who_can_see_my_page) throws DBSystemException;
    public void Update_what_about_can_see(String id,String New_who_can_see_my_page) throws DBSystemException;
    public Ather_page SelectUserAther_page(String id) throws DBSystemException;
    public void insertAtherPage(String userId) throws DBSystemException;

}
