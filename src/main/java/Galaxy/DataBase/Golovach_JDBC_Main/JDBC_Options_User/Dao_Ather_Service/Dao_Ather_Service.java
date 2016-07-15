package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Ather_Service {
    public void UpdateMy_friends(String id,String NewMy_friends) throws DBSystemException;
    public void UpdateMy_group(String id,String NewMy_group) throws DBSystemException;
    public void UpdateMy_mysic(String id,String NewMy_mysic) throws DBSystemException;
    public void UpdateMy_photo(String id,String NewMy_photo) throws DBSystemException;
    public void UpdateMy_video(String id,String NewMy_video) throws DBSystemException;
    public void UpdateMy_massege(String id,String NewMy_massege) throws DBSystemException;
    public void UpdateMy_news(String id,String NewMy_news) throws DBSystemException;
    public void UpdateMy_answers(String id,String NewMy_answers) throws DBSystemException;
    public void UpdateMy_bookmarks(String id,String NewMy_bookmarks) throws DBSystemException;
    public void UpdateMy_aplication(String id,String NewMy_aplication) throws DBSystemException;
    public void UpdateMy_documents(String id,String NewMy_documents) throws DBSystemException;
    public void UpdateMy_blog_presents(String id,String NewMy_blog_presents) throws DBSystemException;
    public Ather_Service SelectUserAther_Service(String id) throws DBSystemException;
    public void insertTrueRegister(String userid) throws DBSystemException;

}
