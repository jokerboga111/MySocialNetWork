package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Change_Email {
    public void UpdateEmail(String id,String NewEmail) throws DBSystemException;
    public Change_Email SelectUserChange_Email(String id) throws DBSystemException;
    public void insertChangeEmailRagister(String id,String Email) throws DBSystemException;
}
