package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education;

/**
 * Created by Admin on 12.02.2016.
 */
public interface Dao_User_Hith_Education {
    public void UpdateCountry(String id,String NewCountry) throws DBSystemException;
    public void UpdateTown(String id,String NewTown) throws DBSystemException;
    public void UpdateUniversity(String id,String NewUniversity) throws DBSystemException;
    public void UpdateDepartment(String id,String NewDepartment) throws DBSystemException;
    public void UpdateChair(String id,String NewChair) throws DBSystemException;
    public void UpdateMode_of_study(String id,String NewMode_of_study) throws DBSystemException;
    public void UpdateStatus(String id,String NewStatus) throws DBSystemException;
    public void UpdateRelease_date(String id,String NewRelease_date) throws DBSystemException;
    public User_Hith_Education SelectUser_Hith_Education(String id) throws DBSystemException;
    public void insertRegisterHightEducation(String Userid) throws DBSystemException;
}
