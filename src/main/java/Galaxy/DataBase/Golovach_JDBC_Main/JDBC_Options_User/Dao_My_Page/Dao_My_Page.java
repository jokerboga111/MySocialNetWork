package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_My_Page {
    public void Update_who_saw_my_info(String id,String New_who_saw_my_info) throws DBSystemException;
    public void Update_who_saw_photo_in_what_you_acept(String id,String New_who_saw_photo_in_what_you_acept) throws DBSystemException;
    public void Update_who_saw_video_in_what_you_acept(String id,String New_who_saw_video_in_what_you_acept) throws DBSystemException;
    public void Update_who_saw_spisok_group(String id,String New_who_saw_spisok_group) throws DBSystemException;
    public void Update_who_saw_spisok_audio(String id,String New_who_saw_spisok_audio) throws DBSystemException;
    public void Update_who_saw_spisok_surprise(String id,String New_who_saw_spisok_surprise) throws DBSystemException;
    public void Update_who_saw_map_photos(String id,String New_who_saw_map_photos) throws DBSystemException;
    public void Update_who_saw_friends_and_pidpish(String id,String New_who_saw_friends_and_pidpish) throws DBSystemException;
    public void Update_who_saw_my_skritish_friends(String id,String New_who_saw_my_skritish_friends) throws DBSystemException;
    public My_page SelectUserMy_page(String id) throws DBSystemException;
    public void insertMy_pageRegister(String idUser) throws DBSystemException;

}
