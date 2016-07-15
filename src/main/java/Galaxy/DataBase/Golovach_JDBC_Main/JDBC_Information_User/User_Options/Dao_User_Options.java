package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Options;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;

/**
 * Created by Admin on 13.02.2016.
 */
public interface Dao_User_Options {

    public void Update_My_friends(String id,String New_My_friends) throws DBSystemException;
    public void Update_My_group(String id,String New_My_group) throws DBSystemException;
    public void Update_My_mysic(String id,String New_My_mysic) throws DBSystemException;
    public void Update_My_photo(String id,String New_My_photo) throws DBSystemException;
    public void Update_My_video(String id,String New_My_video) throws DBSystemException;
    public void Update_My_massege(String id,String New_My_massege) throws DBSystemException;
    public void Update_My_news(String id,String New_My_news) throws DBSystemException;
    public void Update_My_answers(String id,String New_My_answers) throws DBSystemException;
    public void Update_My_bookmarks(String id,String New_My_bookmarks) throws DBSystemException;
    public void Update_My_aplication(String id,String New_My_aplication) throws DBSystemException;
    public void Update_My_documents(String id,String New_My_documents) throws DBSystemException;
    public void Update_My_blog_presents(String id,String New_My_blog_presents) throws DBSystemException;
    public Iformation_User SelectUserInformation(String id) throws DBSystemException;
}
