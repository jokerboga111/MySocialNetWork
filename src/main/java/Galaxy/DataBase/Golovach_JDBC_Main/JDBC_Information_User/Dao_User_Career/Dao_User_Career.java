package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education.User_Education;

/**
 * Created by Admin on 12.02.2016.
 */
public interface Dao_User_Career {
    public void UpdateCountry(String id,String NewCountry) throws DBSystemException;
    public void UpdateTown(String id,String NewTown) throws DBSystemException;
    public void UpdatePosition(String id,String NewPosition) throws DBSystemException;
    public void UpdateYear_Start_Study(String id,String NewYear_Start_Study) throws DBSystemException;
    public void UpdateYear_End_Study(String id,String NewYear_End_Study) throws DBSystemException;
    public void UpdatePlace_To_work(String id,String NewPlace_To_work) throws DBSystemException;
    public User_Career SelectUser_Career(String id) throws DBSystemException;
    public void insertCareaRegistr(String userId) throws DBSystemException;

}
