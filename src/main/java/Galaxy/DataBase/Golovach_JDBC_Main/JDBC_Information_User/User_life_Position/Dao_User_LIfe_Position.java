package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career.User_Career;

/**
 * Created by Admin on 12.02.2016.
 */
public interface Dao_User_LIfe_Position {
    public void UpdatePolitical_answ(String id,String NewPolitical_answ) throws DBSystemException;
    public void Updateworldview(String id,String Newworldview) throws DBSystemException;
    public void Updatemain_in_life(String id,String Newmain_in_life) throws DBSystemException;
    public void Updatemain_in_people(String id,String Newmain_in_people) throws DBSystemException;
    public void Updateattitude_about_smoking(String id,String Newattitude_about_smoking) throws DBSystemException;
    public void UpdatePierian_spring(String id,String NewPierian_spring) throws DBSystemException;
    public void Updateattitude_about_alcohole(String id,String Newattitude_about_alcohole) throws DBSystemException;
    public User_Life_Position SelectUser_Life_Position(String id) throws DBSystemException;
    public void insertLifePosRegister(String id)  throws DBSystemException;

}
