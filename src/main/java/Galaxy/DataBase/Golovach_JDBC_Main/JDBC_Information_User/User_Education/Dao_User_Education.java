package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo;

/**
 * Created by Admin on 12.02.2016.
 */
public interface Dao_User_Education {
    public void UpdateCountry(String id,String NewCountry) throws DBSystemException;
    public void UpdateTown(String id,String NewTown) throws DBSystemException;
    public void UpdateSchool(String id,String NewSchool) throws DBSystemException;
    public void UpdateYear_Start_Study(String id,String NewYear_Start_Study) throws DBSystemException;
    public void UpdateYear_End_Study(String id,String NewYear_End_Study) throws DBSystemException;
    public void UpdateData_End(String id,String NewData_End) throws DBSystemException;
    public void UpdateClass(String id,String NewClass) throws DBSystemException;
    public void UpdateSpechialization(String id,String NewSpechialization) throws DBSystemException;
    public User_Education SelectUser_Education(String id) throws DBSystemException;
    public void insertEducationRegister(String userId) throws DBSystemException;
}
