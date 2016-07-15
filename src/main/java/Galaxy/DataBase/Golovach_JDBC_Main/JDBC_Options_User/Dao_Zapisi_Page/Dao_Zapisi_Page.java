package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Zapisi_Page {
    public void Update_who_saw_bad_zapisi(String id,String New_who_saw_bad_zapisi) throws DBSystemException;
    public void Update_who_can_cryare_zapisi(String id,String New_who_can_cryare_zapisi) throws DBSystemException;
    public void Update_who_saw_coments_to_zapisi(String id,String New_who_saw_coments_to_zapisi) throws DBSystemException;
    public void Update_who_can_coment_my_zapisi(String id,String New_who_can_coment_my_zapisi) throws DBSystemException;
    public Zapisi_page SelectUserZapisi_page(String id) throws DBSystemException;
    public void insertZapisiPageRagistretion(String idUser) throws DBSystemException;

}
