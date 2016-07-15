package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.User_Life_Position;

/**
 * Created by Admin on 12.02.2016.
 */
public interface User_Dao_service {
    public void UpdateCountry(String id,String NewCountry) throws DBSystemException;
    public void UpdateServise(String id,String NewServise) throws DBSystemException;
    public User_service SelectUser_Life_Position(String id) throws DBSystemException;
    public void insertServiceRegister(String userid)throws DBSystemException;
}
