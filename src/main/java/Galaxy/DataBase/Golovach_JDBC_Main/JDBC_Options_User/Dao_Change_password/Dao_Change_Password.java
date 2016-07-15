package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.Change_Id;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Change_Password {
    public void UpdatePassWord(String id,String NewPassword)throws DBSystemException;
    public Change_Pasword SelectUserChange_Id(String id) throws DBSystemException;;
}
