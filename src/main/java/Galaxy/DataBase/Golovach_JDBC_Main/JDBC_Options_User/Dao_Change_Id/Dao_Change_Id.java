package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Change_Email;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Change_Id {
    public void UpdateId(String id,String NewId) throws DBSystemException;
    public Change_Id SelectUserChange_Id(String id) throws DBSystemException;
    public void inserIdREgister(String Id) throws DBSystemException;
}
