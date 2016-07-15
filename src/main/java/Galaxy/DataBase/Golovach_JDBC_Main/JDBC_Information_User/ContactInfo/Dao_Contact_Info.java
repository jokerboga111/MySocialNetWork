package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;

/**
 * Created by Admin on 11.02.2016.
 */
public interface Dao_Contact_Info {
    public void UpdateCountry(String id,String NewCountry) throws DBSystemException;
    public void UpdateTown(String id,String NewTown) throws DBSystemException;
    public void UpdateHouse(String id,String NewHouse) throws DBSystemException;
    public void UpdateMyPhone(String id,String NewMyPhone) throws DBSystemException;
    public void UpdateSkype(String id,String NewSkype) throws DBSystemException;
    public void UpdateMySite(String id,String NewMySite) throws DBSystemException;
    public ContactInfo SelectContactInformation(String id) throws DBSystemException;
    public void insertContactRegister(String userid)throws  DBSystemException;

}
